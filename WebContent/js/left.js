var tree = {
	setting : {
		url:'',
		isSimpleData : true,
		treeNodeKey : "id",
		treeNodeParentKey : "pid",
		showLine : true,
//		checkable : true,
		root : {
			isRoot : true,
			nodes : []
		}
	},
	loadTree : function() {
		$("#menuTree").zTree(tree.setting);
		$.post("/oa/showMenuitemTreeByUid",null,function(data){
			$("#menuTree").zTree(tree.setting, data);
		},"json");
	}
};

$().ready(function() {
	console.log("start()");
	tree.loadTree();
});