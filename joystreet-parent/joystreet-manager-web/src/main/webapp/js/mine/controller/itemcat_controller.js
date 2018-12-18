
app.controller("itemcatController", function ($scope, $http, $controller) {
    // 继承base控制
    $controller("baseController", {$scope:$scope});

    // ******* 面包屑导航 ********
    $scope.grade = 1;

    // 设置级别
    $scope.setGrade = function (value) {
        $scope.grade = value;
    }

    // 读取列表
    $scope.selectList = function(p_entity){
        if($scope.grade==1){//如果为1级
            $scope.entity_1=null;
            $scope.entity_2=null;
        }
        if($scope.grade==2){//如果为2级
            $scope.entity_1=p_entity;
            $scope.entity_2=null;
        }
        if($scope.grade==3){//如果为3级
            $scope.entity_2=p_entity;
        }
        $scope.queryNextLevel(p_entity.id);
    }

    // 查询下级
    $scope.queryNextLevel =  function (parentId) {
        $scope.search.parentId = parentId;
        $scope.reloadList();
    }

    // 分页查询
    $scope.queryByPage = function (page, rows, search) {
        $http({
            method : 'POST',
            url : getRootPath()+"/itemcat/queryByParent",
            data : $.param({
                page : page,
                rows : rows,
                parentId : search.parentId
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
});