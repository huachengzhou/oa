var privilege = {
	/* 存放数据 save data */
	data:{
		role : {
			rid : '',
			name : ''
		},
	},
	/*初始化*/
	init:{
		/*初始化数据*/
		initData:function(){
			/* a 标签的父节点,然后找它的兄弟节点,最后找它的兄弟节点的第一个元素,再取值,赋值 */
			privilege.data.role.name = $(this).parent().siblings("td:first").text();
    		/* a 标签的父节点 即td,然后在找它的兄弟节点 ,然后找到input,属性为hidden */
    		privilege.data.role.rid = $(this).parent().siblings("input").val();
		},
		/*-------------------------------初始化事件 initEvent start----------------------*/
		initEvent:function(){
			/*给设置权限添加click事件?*/
			$("a").each(function() {
				if ($(this).attr("title")=="N_QUAN") {
					$(this).unbind("click");
					$(this).bind("click",function(){
						/*1:使所有的隐藏div显示*/
						privilege.option.divOpt.showDiv();
						/*2:给user中的name和uid赋值*/
						privilege.data.role.rid = $(this).parent().siblings("input").val();
						privilege.data.role.name = $(this).parent().siblings("td:first").text();
						/*3:动态的显示用户名*/
						privilege.option.roleOpt.showRoleName();
						/*
						 * 经过分析可以得出
						 * 角色树没有加载出来的情况下,全选复选框是不能点的,只有当角色树加载出来的情况下才能点击
						 */
						/* 设置全选框的值为不可用 */
						privilege.option.privilegeTree.isAllChecked(false);
						/* 显示loading 隐藏roleTree */
						privilege.option.roleOpt.changeLoadingAndRoleTree({privilegeTree:true});
						/*4:加载角色树*/
						privilege.option.privilegeTree.loadPrivilegeTree();
						return false;
					});
				}
			});
			/*给全选复选框添加change事件*/
    		$("#cbSelectAll").unbind("change");
			$("#cbSelectAll").bind("change", function() {
				privilege.option.privilegeTree.allChecked.call(this);
			});
			/* 给保存操作添加click事件 */
			$("#savePrivilege").unbind("click");
			$("#savePrivilege").bind("click", function() {
				privilege.option.privilegeTree.savePrivilege();
			});
		}
		/*-------------------------------初始化事件 initEvent end----------------------*/
	},
	/*------------------------------分割线option start-----------------------------*/
	option:{
		roleOpt:{
			showRoleName:function(){
				$("#roleNameImage").text(privilege.data.role.name);
			},
			/* 从Loading.gif到roleTree的转化 */
			changeLoadingAndRoleTree:function(json){
				if (json.privilegeTree) {
    				$("#privilegeTree").show();
					$("#loading").hide();
				}else {
					$("#privilegeTree").hide();
					$("#loading").show();
				}
			}
		},
		divOpt:{
			showDiv:function(){
				$("div:hidden").show();
			}
		},
		/*........................分割线privilegeTree start.............................*/
		privilegeTree:{
			zTreeplugin:'',
			setting: {
				isSimpleData: true,
				treeNodeKey: "id",
				treeNodeParentKey: "pid",
				showLine: true,
				root: {
					isRoot: true,
					nodes: []
				},
				checkable:true,
				callback:function(){
					privilege.option.privilegeTree.setAllCheckedValue();
				}
			},
			/*加载权限树*/
			loadPrivilegeTree:function(){
				$("#privilegeTree").zTree(privilege.option.privilegeTree.setting);
				$.post("http://localhost:8080/oa/showPrivilegeByRid","rid="+privilege.data.role.rid,function(data){
					privilege.option.privilegeTree.zTreeplugin = $("#privilegeTree").zTree(privilege.option.privilegeTree.setting,data);
					/* 必须等角色树加载出来以后才恢复可用状态 设置全选框为可用状态 */
					privilege.option.privilegeTree.isAllChecked(false);
					/* 当整个角色树被加载下来以后,隐藏loading.gif加载releTree */
					privilege.option.roleOpt.changeLoadingAndRoleTree({privilegeTree:true});
					/*设置全选复选框初始化状态的值*/
					privilege.option.privilegeTree.setAllCheckedValue();
				},"json");
			},
			/*设置全选复选框的状态*/
			isAllChecked:function(checked){
				$("#cbSelectAll").attr("disabled", checked);
			},
			/*设置全选复选框的默认值 */
			setAllCheckedValue:function(){
				/*返回 zTree 当前checkBox / radio 输入框被选择 或 未选择的节点集合:false表示全部没被选中的集合*/
				var uncheckedNodes = privilege.option.privilegeTree.zTreeplugin.getCheckedNodes(true);
				if (uncheckedNodes.length==0) {
					$("#cbSelectAll").attr("checked",true);
				}else {
					$("#cbSelectAll").attr("checked",false);
				}
			},
			/*全选复选框的功能*/
			allChecked:function(){
				if ($(this).attr("checked")) {
					privilege.option.privilegeTree.zTreeplugin.checkAllNodes(true);
				}else {
					privilege.option.privilegeTree.zTreeplugin.checkAllNodes(false);
				}
			},
			/*保存*/
			savePrivilege:function(){
				/*1:获取所有角色所有rid*/
				var checkedNodes = privilege.option.privilegeTree.zTreeplugin.getCheckedNodes(true);/*获取所选角色*/
				var str = "";
				for (var i = 0; i < checkedNodes.length; i++) {
					if ((checkedNodes.length-1)==i) {
						str += checkedNodes[i].id;
					}else {
						str += checkedNodes[i].id + ",";
					}
				}
				var rid = privilege.data.role.rid;
				$.post("/oa/savePrivilege__","rid="+rid+"&str="+str,function(data){
					if (data!=null) {
						alert(data);
					}else {
						alert("error");
					}
				});
//				var url = "/oa/savePrivilege__?"+"rid="+rid+"&str="+str;
//				window.location.href = url;
			}
		}
		/*........................分割线privilegeTree end.............................*/
	}
	/*------------------------------分割线option end-----------------------------*/
};

$().ready(function() {
	privilege.init.initEvent();
});