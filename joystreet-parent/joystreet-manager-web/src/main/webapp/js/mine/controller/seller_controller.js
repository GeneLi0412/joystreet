
app.controller("sellerController", function ($scope, $http, $controller) {
    // 继承base控制
    $controller("baseController", {$scope:$scope});

    // 分页查询
    $scope.queryByPage = function (page, rows, search) {
        $http({
            method : 'POST',
            url : getRootPath()+"/seller/queryByPage",
            data : $.param({
                page : page,
                rows : rows,
                companyName : search.companyName,
                shopName : search.shopName
            }),
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(!resp.error){
                var data = resp.data;
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            }else{
                alert(resp.message)
            }
        });
    }
});