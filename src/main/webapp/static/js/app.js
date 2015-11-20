angular.module("notification",[])
.controller("NotificationController", function(NotificationService, $log){
	this.notifications = NotificationService.getNotifications();
})
.service("NotificationService", function($http,$q){
	
	var notifications = {
			list: []
	};
	this.getNotifications = function(){
		return notifications;
	};
	function poll(){
		$http.get("/notifications")
		.then(function(response){
			notifications.list = response.data;
			poll();
		},
		function(error){
			//promise.reject(error);
			//poll();
		});
	}
	poll();
});