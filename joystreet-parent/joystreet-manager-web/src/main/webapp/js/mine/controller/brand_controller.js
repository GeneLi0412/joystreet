
// 绑定控制器
app.controller("brandController", function($scope, $controller, $http){

    // 引入基础控制层
    $controller("baseController", {$scope:$scope});

    // 读取列表数据，绑定到表单当中
    $scope.queryByPage = function(page, rows, search){
        $http({
            method: 'POST',
            url: getRootPath()+"/brand/queryByPage",
            data: $.param({
                page: page,
                rows: rows,
                search: search.text
            }),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
            }
        }).success(
            function(response){
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }

    // 保存数据
    $scope.save = function(){
        var method = "/brand/saveBrand";
        if($scope.brand.id != null){
            method = "/brand/updateBrand";
        }
        $http.post(getRootPath()+method, $scope.brand).success(
            function(response){
                if(!response.error){
                    $scope.reloadList();
                    $scope.brand = {};
                }
            }
        );
    }

    // 根据品牌ID查询数据
    $scope.findOne = function(id){
        $http.get(getRootPath()+"/brand/findOne?id="+id).success(
            function(response){
                if(!response.error){
                    $scope.brand = response.data;
                }
            }
        );
    };

    // 删除
    $scope.delete = function(){
        // 判断是否为空
        if($scope.selectIds.length <= 0){
            alert("请选择至少一条数据");
        }else{
            $http.get(getRootPath()+"/brand/deleteByIds?ids="+$scope.selectIds).success(function(resp){
                if(!resp.error){
                    $scope.reloadList();
                    $scope.selectIds = [];
                }else{
                    alert(resp.message);
                }
            });
        }
    }

});