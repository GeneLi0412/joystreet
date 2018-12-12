
app.controller("registerController", function ($scope, $http, $controller) {

    $controller("baseController", {$scope:$scope});

    // 新增商家
    $scope.addSeller = function () {
        $http({
            method : "post",
            url : getRootPath()+"/seller/register",
            transformRequest : function(obj) {
                var str = [];
                for(var p in obj){
                    if(obj[p] != undefined){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                }
                return str.join("&");
            },
            data : $scope.seller,
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp) {
            if(resp.error){
                alert(resp.message);
            }else{

            }
        })
    }
});