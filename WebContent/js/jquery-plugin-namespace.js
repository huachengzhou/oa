(function($){
	/**
	 * @param {Object} namespace
	 *     "cn.itcast.oa.TreePanel"
	 */
    $.nameSpace = function(namespace){
		/**
		 * ss[]={"cn","itcast","oa","TreePanel"}
		 */
        var ss = namespace.split(".");
        var tempNs = [];
		/**
		 * 当第一遍循环
		 *    window.cn
		 * 当第二遍循环
		 *    window.cn.itcast
		 *    ......
		 */
        for (var i = 0; i < ss.length; i++) {
            tempNs.push(ss[i]);
            var n = tempNs.join(".");
            if (typeof window[n] != "object") {
                eval("window." + n + "={}");
            }
        }
    }
})($);

//$().ready(function(){
//	$.nameSpace("cn.itcast.oa.TreePanel");
//	alert(window.cn.itcast.oa.TreePanel);
//});

