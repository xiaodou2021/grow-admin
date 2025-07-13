window.eruptSiteConfig = {
    //erupt接口地址，在前后端分离时指定
    domain: "",
    //附件地址，一般情况下不需要指定，如果自定义对象存储空间，则需在此指定附件资源访问地址
    fileDomain: "",
    //标题
    title: "GrowAdminSystem",
    //描述
    desc: "小游戏养成后台系统",
    //是否展示版权信息
    copyright: true,
    //自定义版权内容，1.12.8及以上版本支持，值可以是方法也可以是字符串,1.12.15及以上版本支持渲染标签
    copyrightTxt: function() {
        return "版权信息xxxx"
    },
    //高德地图 api key,使用地图组件须指定此属性，amapKey获取地址：https://lbs.amap.com (服务平台为：Web端(JS API))
    amapKey: "xxxx",
    //高德地图 SecurityJsCode
    amapSecurityJsCode: "xxxxx",
    //logo路径
    logoPath: "favicon.ico",
    //菜单折叠后的logo路径，1.12.21及以上版本支持
    logoFoldPath: null,
    //logo文字
    logoText: "IGM",
    //注册页地址，会在登录页面增加一个链接 (仅是一个链接，需要自定义实际样式)
    registerPage: "",
    //触碰用户头像后的菜单，功能列表扩展，1.12.21及以上版本支持
    userTools: [{
        text: "自定义用户工具栏",
        icon: "fa fa-snowflake-o",
        click: function (event) {
            alert("On Click")
        }
    }],
    //自定义导航栏按钮，配置后将会出现在页面右上角
    r_tools: [{
        icon: "fa-eercast",
        // 自定义渲染内容,支持渲染HTML,参数值可以是字符串也可以是方法，1.12.21及以上版本支持
        render: () => {
            return `<h2>自定义渲染</h2>`
        },
        // 手机端是否隐藏
        mobileHidden: false,
        //点击事件
        click: function (event) {
            alert("Function button");
        }
    }],
    //登录成功事件 1.12.3 及以上版本移动至window.eruptEvent中声明
    login: function(user){

    },
    //注销事件 1.12.3 及以上版本移动至window.eruptEvent中声明
    logout: function(user){

    }
};

//路由回调函数
window.eruptRouterEvent = {
    //key表示要监听的路由切换地址，为url hash地址最后一段
    //例如：http://www.erupt.xyz:9999/#/build/table/demo中demo为回调key
    demo: {
        //路由载入事件
        load: function (e) {

        },
        //路由退出事件
        unload: function (e) {

        }
    },
    //$ 为全路径通配符，在任何路由切换时都会执行load与unload事件
    $: {
        load: function (e) {

        },
        unload: function (e) {
        }
    }
};

//erupt生命周期函数
window.eruptEvent = {
    //页面加载完成后回调
    startup: function () {

    },
    //登录成功
    login: function(user){
        window.notify.success("Tip", "login success",{
            nzPlacement: "bottom"
        })
    },
    //注销事件
    logout: function(user){

    }
}