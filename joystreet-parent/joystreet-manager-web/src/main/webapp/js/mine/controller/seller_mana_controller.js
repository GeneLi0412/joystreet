
app.controller("sellerManaController", function ($scope, $http, $controller) {

    // 引入基础控制
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
                shopName : search.shopName,
                status : search.status
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
                alert(resp.message);
            }
        });
    }

    //展示商家详情
    $scope.showDetSeller = function (seller) {
        $scope.entity = seller;
    }

    // 更新商家状态
    $scope.updateSeller = function (sellerId, status) {
        $http({
            method : 'POST',
            url : getRootPath()+"/seller/updateSellerStatus",
            data : $.param({
                sellerId : sellerId,
                status : status
            }),
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(!resp.error){
                $scope.reloadList();
                alert("更新成功！");
            }else{
                alert(resp.message);
            }
        });
    }
    
});