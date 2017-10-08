/*
 * 
 * */
var tree = {
	setting : {
		isSimpleData : true,
		treeNodeKey : "mid",
		treeNodeParentKey : "pid",
		showLine : true,
		checkable : true,
		root : {
			isRoot : true,
			nodes : []
		}
	},
	loadTree : function() {
		$("#tree").zTree(tree.setting);
		$.ajax({
	          type:"GET",
	          url:"http://localhost:8080/oa/isMenuitemXX",
	          dataType:"jsonp",
	          jsonp:"callbackParam",
	          jsonpCallback:"success_jsonCallback",
	          success:function(data){
	        	  $("#tree").zTree(tree.setting, data);
	          },
	          error:function(){
	              alert("error");
	          }       
	      });
	}
};

$().ready(function() {
	console.log("start()");
	tree.loadTree();
});
/*
 * 
 * {'id':'1','name':'test','pid':'2'},{'id':'2','name':'test1','pid':'1'},
 * {'id':'3','name':'test2','pid':'1'},{'id':'4','name':'test3','pid':'1'},
 * {'id':'5','name':'test4','pid':'1'},{'id':'6','name':'test5','pid':'1'}
 * isRoot:true, nodes:[]
 */