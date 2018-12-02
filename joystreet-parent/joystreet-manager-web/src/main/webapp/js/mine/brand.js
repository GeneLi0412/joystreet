/**
 * Created by 、Bonjour on 2018/12/1.
 */

// 定义模块
var app = angular.module("joystreet",["pagination"]);

// 绑定控制器
app.controller("brandController", function($scope, $http){

    // 重新加载列表
    $scope.reloadList = function(){
        // 切换页码
        $scope.findByPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    // 分页控制配置
    $scope.paginationConf = {
        currentPage:1,
        totalItems:10,
        itemsPerPage:10,
        perPageOptions:[10,20,30],
        onChange:function(){
            $scope.reloadList();
        }
    };

    // 读取列表数据，绑定到表单当中
    $scope.findByPage = function(page, rows){
        $http.get(getRootPath()+"/brand/queryByPage?page="+ page +"&rows="+ rows).success(
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

    // 更新复选框列表
    $scope.selectIds = [];
    $scope.updateSelection = function (checked, id){
        // 如果复选框为选中状态
        if(checked){
            $scope.selectIds.push(id);
        }else{
            // 获得ID在数组中的索引
            var index = $scope.selectIds.indexOf(id);
            if(index != -1){
                // 剔除
                $scope.selectIds.splice(index, 1);
            }
        }
    };

    // 选择所有
    $scope.selall = function($event){
        var bids = document.getElementsByName("brandId");
        for(var i=0;i<bids.length;i++){
            bids[i].checked = $event.target.checked;
        }
        if($event.target.checked){
            var brands = $scope.list;
            for(var j=0;j<brands.length;j++){
                var ind = $scope.selectIds.indexOf(brands[j].id);
                if(ind == -1){
                    $scope.selectIds.push(brands[j].id);
                }
            }
        }else{
            $scope.selectIds = [];
        }
    }

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