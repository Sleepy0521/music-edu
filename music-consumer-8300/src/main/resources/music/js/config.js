'use strict';

var config = {

    //前端接口地址
    serverUrl: window.location.protocol + "//" + window.location.host+"/degradeApi",
    //路由接口地址
    zuulUrl: "http:" + "//" + "127.0.0.1:8600",
    //接口应用
    serverApp: 'pasture-api'

};

// 接口地址
var serverUrl = config.serverUrl;
var zuulUrl=config.zuulUrl;
var zuulUrlFile=config.zuulUrl+"/api/music/download/";
// 接口地址
var serverApp = config.serverApp;


