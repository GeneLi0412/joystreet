
// 加载angular模块
var app = angular.module("joystreet",["pagination"]);

app.controller("specificController", function ($scope, $http) {

    // 分页查询
    $scope.queryByPage = function (page, rows, searchText) {
        $http({
            method : 'POST',
            url : getRootPath()+"/specification/queryByPage",
            data : $.param({
                page : page,
                rows : rows,
                searchText : searchText
            }),
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(!resp.error){
                var data = resp.result;
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            }else{
                alert(resp.message)
            }
        });
    }

    // 重新加载数据
    $scope.reloadList = function () {
        $scope.queryByPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.searchText);
    }
    
    // 配置分页
    $scope.paginationConf = {
        currentPage : 1,
        itemsPerPage : 10,
        perPageOptions: [5,10,15,20,25,30],
        onChange: function () {
            $scope.reloadList();
        }
    };

    /**********************查询规格行*************************/
    $scope.findOne = function (specificId) {
        $scope.initSpecific();
        $http({
            method : 'post',
            url : getRootPath()+"/specification/findOne",
            data : $.param({
                id : specificId
            }),
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp) {
            if(!resp.error){
                $scope.specific.id = resp.data.id;
                $scope.specific.specName = resp.data.specName;
                if(resp.data.specificationOptions.length > 0){
                    $scope.specific.options = resp.data.specificationOptions;
                }
            }else{
                alert(resp.message)
            }
        });
    }


    /************************新增规格行*************************/
    // 初始化
    $scope.initSpecific = function () {
        $scope.specific = {options:[{}]};
    }

    // 新增规格行
    $scope.addOptionRow = function () {
        $scope.specific.options.push({});
    }
    
    // 删除规格行
    $scope.dropRow = function (index) {
        if($scope.specific.options.length > 1){
            $scope.specific.options.splice(index, 1);
        }
    }

    /***********************新增、修改**************************/
    $scope.saveOrModify = function () {
        // 封装数据
        var options = $scope.specific.options;
        var names = [];
        var orders = [];
        for(var i=0;i<options.length;i++){
            names.push(options[i].optionName);
            orders.push(options[i].orders);
        }

        $http({
            method : 'POST',
            url : getRootPath()+"/specification/saveOrModify",
            transformRequest: function(obj) {
                var str = [];
                for(var p in obj){
                    if(obj[p] != undefined){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                }
                return str.join("&");
            },
            data : {
                specificId : $scope.specific.id,
                specificName : $scope.specific.specName,
                optionNames : names,
                optionOrders : orders
            },
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(resp.error){
                alert(resp.message)
            }else{
                $scope.reloadList()
            }
        });
    }

    /************************批量删除*************************/
    $scope.selectIds = [];

    $scope.delete = function () {
        $http({
            method : 'POST',
            url : getRootPath()+"/specification/deleteByIds",
            transformRequest: function(obj) {
                var str = [];
                for(var p in obj){
                    if(obj[p] != undefined){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                }
                return str.join("&");
            },
            data : {
                ids : $scope.selectIds
            },
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(resp.error){
                alert(resp.message)
            }else{
                $scope.reloadList();
                $scope.selectIds = [];
            }
        });
    }
    
    // 选择所有
    $scope.selectAll = function (event, cbname) {
        var cbs = document.getElementsByName(cbname);
        for(var i=0;i<cbs.length;i++){
            cbs[i].checked = event.target.checked;
        }
        if(event.target.checked){
            for(var i=0;i<$scope.list.length;i++){
                var id = $scope.list[i].id;
                if($scope.list.indexOf(id) == -1){
                    $scope.selectIds.push(id);
                }
            }
        }else{
            $scope.selectIds = [];
        }
    }

    // 选择单个
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
});
