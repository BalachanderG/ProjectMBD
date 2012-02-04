package com.grl.json.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.grl.json.client.exceptions.ClientException;
import com.grl.json.messages.ClientErrorResponse;
import com.grl.json.messages.Request;
import com.grl.json.messages.Response;


public class Client {
	private static final int DEFAULT_TIMEOUT = 10000;
	private HttpClient httpClient = new DefaultHttpClient();

	private CookieStore cookieStore = new BasicCookieStore();
	private HttpContext localContext = new BasicHttpContext();

	private URL serverAddress;
	
	private boolean connected;
	
	private Object lock = new Object();
	
	public Client(URL address){
		serverAddress = address;
		localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		httpClient = wrapClient(httpClient);
		setTimeout(DEFAULT_TIMEOUT);
	}
	public void loadCookies(File file){
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			cookieStore = (CookieStore)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			cookieStore = new BasicCookieStore();
		} 

		localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
	}
	public void storeCookies(File file){
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cookieStore);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean connected(){
		synchronized(lock){
			return connected;
		}
	}
	public boolean testConnection(){
		try{
			return sendRequest(new com.grl.json.messages.PingRequest(System.currentTimeMillis())).getSuccess();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	private void setConnected(boolean connected){
		synchronized(lock){
			this.connected = connected;
		}
	}
	private void setTimeout(int timeout){
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, timeout);
		HttpConnectionParams.setSoTimeout(params, timeout);
	}
	public synchronized Response sendRequest(Request request, int timeout){
		setTimeout(timeout);
		Response response = sendRequest(request);
		setTimeout(DEFAULT_TIMEOUT);
		return response;
	}
	
	public synchronized Response sendRequest(Request request){
		setConnected(false);
		HttpPost post = new HttpPost(serverAddress.toString());
		HttpEntity responseEntity = null;
		Response message = null;
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			StringEntity entity = new StringEntity(mapper.writeValueAsString(request));
			post.setEntity(entity);
			entity.setContentType("application/json");
			HttpResponse response;
			synchronized(httpClient){
				response = httpClient.execute(post,localContext);
			}
			
			responseEntity = response.getEntity();
			InputStream inStream = responseEntity.getContent();
			
			if(responseEntity.getContentType() != null){
				message = mapper.readValue(inStream,Response.class);

				inStream.close();
				setConnected(true);
			}
			else{
				throw new ClientException("Able to connect but response is not from Simpl Server. Incorrect URL?");
			}
		} 
		catch (ClientException e) {
			e.printStackTrace();
			message = new ClientErrorResponse(e);
		}
		catch(Exception e){
			e.printStackTrace();
			message = new ClientErrorResponse(e);
		}
		finally{
			try {
				EntityUtils.consume(responseEntity);
			} catch (IOException e) {
				message = new ClientErrorResponse(e);
			}
		}
		return message;
	}
	private static HttpClient wrapClient(HttpClient base) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = base.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", ssf, 443));
            return new DefaultHttpClient(ccm, base.getParams());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
