function initHeader(highMenu){
    //给header添加当前页面样式
    $('.menu').find('li').removeClass("active");
    $('#'+highMenu).addClass("active");
    //判断cookie根据不同的cookie显示不同的块
    var username=$.cookie('username');
    //若cookie中有用户名则显示登陆后的
    if(username!=""){
        $('#menuLoginAfter').show();
        $('#menuLoginBefore').hide();
        //用户名的显示
        $('#menuUsername').text(username);
    }
    //若没有则显示登陆前的
    else{
        $('#menuLoginAfter').hide();
        $('#menuLoginBefore').show();
    }
    //登出功能的绑定
    $('#logout').click(function () {
        $.cookie('username', '');
        window.location.href="/index.html"
    });
}
function addHeaderAndFooter() {
    //加载header
    $('.header_top').load("./page/component/header.html");
    //加载footer
    $('.footer').load("./page/component/footer.html");
    $('.copy').load("./page/component/link.html");

   /* var msgSuccess = {};
    msgSuccess.dialog1 = jqueryAlert({
        'content': '处理成功',
        'closeTime': 2000,
    });
    var msgFail={};
    msgFail.dialog1 = jqueryAlert({
        'content': '处理失败',
        'closeTime': 2000,
    });*/
}
