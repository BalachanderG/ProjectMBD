/**
 * 
 */
package in.co.blackphoenix.shexp.jdo.test;

import java.util.List;

import in.co.blackphoenix.shexp.jdo.PerUserTransaction;

import javax.jdo.FetchPlan;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 * @author Manoj
 *
 */
public class JdoRetrieveOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PersistenceManager pm = in.co.blackphoenix.shexp.jdo.PMF.get();
		try{
			pm.getFetchPlan().setFetchSize(FetchPlan.FETCH_SIZE_GREEDY);
			Query q = pm.newQuery(PerUserTransaction.class);
			
			List<PerUserTransaction> results = (List<PerUserTransaction>) q.execute();
			
			for(PerUserTransaction result: results){
				
				System.out.println(result.getMyName());
			}
		}finally
		{
			pm.close();
		}
		
	}

}
