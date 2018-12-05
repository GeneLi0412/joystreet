
app.controller("templateController", function ($scope, $controller, $http) {

    $controller("baseController", {$scope:$scope});

    /****************** 全局 ******************/
    $scope.initTemplate = function () {
        $scope.template = {};
    }

    /****************** 下拉列表 ******************/
    // 品牌下拉列表
    $scope.brandList = {};
    // 规格下拉列表
    $scope.specList = {};
    
    // 查询品牌列表
    $scope.queryBrandList = function () {
        $http({
            method : 'POST',
            url : getRootPath()+"/brand/queryAll",
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(!resp.error){
                $scope.brandList.data = resp.data;
            }else{
                alert(resp.message);
            }
        });
    }

    // 查询规格列表
    $scope.querySpecificList = function () {
        $http({
            method : 'POST',
            url : getRootPath()+"/specification/queryAll",
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp){
            // 后台处理成功
            if(!resp.error){
                $scope.specList.data = resp.data;
            }else{
                alert(resp.message);
            }
        });
    }
    
    $scope.initSelect = function () {
        $scope.queryBrandList();
        $scope.querySpecificList();
    }

    /****************** 分页查询 ******************/
    $scope.queryByPage = function (page, rows, search) {
        $http({
            method : 'POST',
            url : getRootPath()+"/template/queryByPage",
            data : $.param({
                page : page,
                rows : rows,
                searchstr : search.text
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

    /******************前往修改页面**********************/
    $scope.toModify = function (template) {
        $scope.initTemplate();
        // id
        $scope.template.id = template.id;
        // name
        $scope.template.name = template.name;
        // 品牌
        $scope.template.brandIds = JSON.parse(template.brandIds);
        // 规格
        $scope.template.specIds = JSON.parse(template.specIds);
        // 扩展属性
        $scope.options = JSON.parse(template.customAttributeItems);
    }

    /*********************新增/修改****************************/
    $scope.saveOrModify = function () {
        console.log(JSON.stringify($scope.template));
        $http({
            method : 'POST',
            url : getRootPath()+"/template/saveOrModify",
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
                id :$scope.template.id,
                name : $scope.template.name,
                brandIds : JSON.stringify($scope.template.brandIds),
                specIds : JSON.stringify($scope.template.specIds),
                customAttributeItems : JSON.stringify($scope.options)
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
});