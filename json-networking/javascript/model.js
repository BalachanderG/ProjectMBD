com = {};
com.grl = {};
com.grl.json = {};


//MESSAGE HANDLING

com.grl.json.messages = {
	callbacks : {},
	responseTypes :{}
};

_ = com.grl.json.messages;

_.sendRequest = function(request){
	if(request!=null){
		$.ajax({
				url: "requests",
				contentType : "application/json",
				data : JSON.stringify(request),
				type: "POST",
				dataType : "json",
				success : com.grl.json.messages.handleResponse
		});
	}
}

_.registerResponseCallback = function(responseType,callback){
	if(com.grl.json.messages.callbacks[responseType]==null)
		com.grl.json.messages.callbacks[responseType] = new Array();
	com.grl.json.messages.callbacks[responseType].push(callback);
}
_.handleResponse = function(data){
	if(data!=null){
		var responseType = data["@class"];
		var typeHierarchy = responseType.split(".");
		var type = window;
		for(key in typeHierarchy){
			type = type[typeHierarchy[key]];
		}
		
		if(com.grl.json.messages.callbacks[responseType]!=null &
			type!=null
		){
			//Handle response
			//var type = com.grl.json.messages.responseTypes[responseType].type;
			for(key in com.grl.json.messages.callbacks[responseType]){
				var callback = com.grl.json.messages.callbacks[responseType][key];
				var response = new type(data);
				callback(response);
			}
		}
	}
}

//DEFAULT MESSAGES
_ = com.grl.json.messages;
_.ErrorResponse = function(data){
	if(data!=null){
		this.message = data.message;
		this.classname = data.classname;
	}
}

_.BatchRequest = function(requests){
	this["@class"] = "com.grl.json.messages.BatchRequest";
	if(requests!=null){
		this.requests = requests;
	}
}

_.BatchResponse = function(data){
	if(data!=null){
		this.success = data.success;
		this.responses = data.responses;
	}
}
