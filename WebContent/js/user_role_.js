var role = {
	/*存放数据*/
    data:{
    	user:{
    		name:'',
    		uid:''
    	}
    },
    init:{
    	/*---------------------------分割线---------------------------------------*/
    	/*初始化数据*/
    	initData:function(){
    		/* a 标签的父节点,然后找它的兄弟节点,最后找它的兄弟节点的第一个元素,再取值,赋值 */
    		role.data.user.name = $(this).parent().siblings("td:first").text();
    		/* a 标签的父节点 即td,然后在找它的兄弟节点 ,然后找到input,属性为hidden */
    		role.data.user.uid = $(this).parent().siblings("input").val();
    	},
    	/*初始化事件*/
    	initEvent:function(){
    		/*给设置权限添加click事件?*/
    		$("a").each(function() {
				if ($(this).attr("title")=="N_QUAN") {
					$(this).unbind("click");
					$(this).bind("click",function(){
						/*1:使所有的隐藏div显示*/
						role.option.divopt.showDiv();
						/*2:给user中的name和uid赋值*/
						role.data.user.name = $(this).parent().siblings("td:first").text();
						role.data.user.uid = $(this).parent().siblings("input").val();
						/*3:动态的显示用户名*/
						role.option.useropt.showUserName();
						/*
						 * 经过分析可以得出
						 * 角色树没有加载出来的情况下,全选复选框是不能点的,只有当角色树加载出来的情况下才能点击
						 */
						/* 设置全选框的值为不可用 */
						role.option.roleopt.changeCheckBoxStatus(true);
						/* 显示loading 隐藏roleTree */
						role.option.roleopt.changeLoadingAndRoleTree({roleTree:false});
						/*4:加载角色树*/
						role.option.roleopt.roleTree.loadRoleTree();
						return false;
					});
				}
			});
    		/*给全选复选框添加change事件*/
    		$("#cbSelectAll").unbind("change");
			$("#cbSelectAll").bind("change", function() {
				role.option.roleopt.allchecked.call(this);
			});
			/* 给保存操作添加click事件 */
			$("#savePrivilege").unbind("click");
			$("#savePrivilege").bind("click", function() {
				alert("save()");
				role.option.roleopt.saveRole();
			});
    	}
    	/*---------------------------分割线---------------------------------------*/
    },
    /*操作*/
    option:{
    	/*...........................分割线...................................*/
    	/* 涉及div的操作 */
    	divopt:{
    		showDiv:function(){
    			/*使所有的隐藏div显示出来*/
    			$("div:hidden").show();
    		}
    	},
    	/*...........................分割线...................................*/
    	/*涉及到的用户操作*/
    	useropt:{
    		showUserName:function(){
    			$("#userNameImage").text(role.data.user.name);
    		}
    	},
    	/*...........................分割线...................................*/
    	/* 涉及到角色树的操作 */
    	roleopt:{
    		/*接受zTree函数的返回值*/
    		zTreePlugin:'',
    		/*???????????????????????*/
    		setting : {
				checkable : true,
				showLine : true,
				isSimpleData : true,
				treeNodeKey : "rid",
				treeNodeParentKey : "pid",
				root : {
					isRoot : true,
					nodes : []
				},
				/*显示树上的复选框*/
				checkable : true,
				callback:{
					change:function(){
						/*调用setAllChecked方法设置全选复选框的状态*/
						role.option.roleopt.setAllChecked();
					}
				}
			},
			/*???????????????????????*/
			roleTree:{
				/* 加载角色树 http://localhost:8080/oa/showTreeRoleObject 跨域加载 */
				loadRoleTree:function(){
					$("#roleTree").zTree(role.option.roleopt.setting);
					$.post("http://localhost:8080/oa/showTreeRoleObject","uid="+role.data.user.uid,function(data){
						/*这得小心了,因为不仅要加载树,而且加载之后还要返回一个值,利用这个值去处理数据和事件*/
						role.option.roleopt.zTreePlugin = $("#roleTree").zTree(role.option.roleopt.setting,data);
//						$("#roleTree").zTree(role.option.roleopt.setting,data);
						/* 必须等角色树加载出来以后才恢复可用状态 设置全选框为可用状态 */
						role.option.roleopt.changeCheckBoxStatus(false);
						/* 当整个角色树被加载下来以后,隐藏loading.gif加载releTree */
						role.option.roleopt.changeLoadingAndRoleTree({roleTree:true});
						/*设置全选复选框初始化状态的值*/
						role.option.roleopt.setAllChecked();
					},"json");
				}
			},
			/*???????????????????????*/
    		/*给复选框添加值 */
    		changeCheckBoxStatus:function(status){
    			$("#cbSelectAll").attr("disabled", status);
    		},
    		/*???????????????????????*/
    		/* 从Loading.gif到roleTree的转化 */
    		changeLoadingAndRoleTree:function(json){
    			if (json.roleTree) {
    				$("#roleTree").show();
					$("#loading").hide();
				}else {
					$("#roleTree").hide();
					$("#loading").show();
				}
    		},
    		/*???????????????????????*/
    		/* 全选复选框的功能 */
    		allchecked:function(){
    			if ($(this).attr("checked")) {
					role.option.roleopt.zTreePlugin.checkAllNodes(true);
				}else {
					role.option.roleopt.zTreePlugin.checkAllNodes(false);
				}
    		},
    		/* 设置全选复选框的状态 */
    		setAllChecked:function(){
    			/*返回 zTree 当前checkBox / radio 输入框被选择 或 未选择的节点集合:false表示全部没被选中的集合*/
    			var uncheckedNodes = role.option.roleopt.zTreePlugin.getCheckedNodes(false);
    			if (uncheckedNodes.length==0) {/*说明全部被选中*/
					$("#cbSelectAll").attr("checked",true);/*当复选框全部被选中,那么全选框则必须被选中*/
				}else {/*没有被全部选中*/
					$("#cbSelectAll").attr("checked",false);
				}
    		},
    		/*保存*/
    		/*建立用户和角色之间的关系*/
    		saveRole:function(){
    			/*1:获取uid和被选中的所有的角色的rid*/
    			var checkedNodes = role.option.roleopt.zTreePlugin.getCheckedNodes(true);/*被选中的所有角色*/
    			var checkedStr = "";
    			/*2:后台只要对用户进行update操作*/
    			for (var i = 0; i < checkedNodes.length; i++) {
					if (i==checkedNodes.length-1) {//最后一个
						checkedStr += checkedNodes[i].rid;
					}else {
						checkedStr += checkedNodes[i].rid + ',';
					}
				};
    			/*ajax端向后台传递的参数*/
				alert(checkedStr+"....");
				var url = "/oa/userRoleController?"+"uid="+role.data.user.uid+"&checkedStr="+checkedStr;
				window.location.href = url;
//    			$.post("/oa/userRoleController","uid="+role.data.user.uid+"&checkedStr="+checkedStrr,function(){
//    				alert("save success!");
//    			});
    		}
    	}
    }
};
$().ready(function() {
	role.init.initEvent();
});