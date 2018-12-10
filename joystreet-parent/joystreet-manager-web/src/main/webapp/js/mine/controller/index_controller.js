
app.controller("indexController", function ($scope, $http) {

    // 请求用户名
    $scope.showUserName = function () {
        $http({
            method : 'POST',
            url : getRootPath()+"/login/userName",
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(resp.error){
                alert(resp.message)
            }else{
                $scope.userName = resp.data;
            }
        });
    };
});