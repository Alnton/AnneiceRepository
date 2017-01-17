for(var i = 0; i < 22; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

if (true) {

	var obj1 = document.getElementById("u5");
    obj1.focus();

}

});
gv_vAlignTable['u20'] = 'center';gv_vAlignTable['u18'] = 'center';gv_vAlignTable['u15'] = 'center';gv_vAlignTable['u11'] = 'center';gv_vAlignTable['u13'] = 'center';u0.tabIndex = 0;

u0.style.cursor = 'pointer';
$axure.eventManager.click('u0', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第1集_原型设计二十条军规.html');

}
});
gv_vAlignTable['u0'] = 'top';u1.tabIndex = 0;

u1.style.cursor = 'pointer';
$axure.eventManager.click('u1', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第3集_图片墙.html');

}
});
gv_vAlignTable['u1'] = 'top';u2.tabIndex = 0;

u2.style.cursor = 'pointer';
$axure.eventManager.click('u2', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('首页.html');

}
});
gv_vAlignTable['u2'] = 'top';
$axure.eventManager.keyup('u5', function(e) {

if ((GetWidgetText('u5')) == ('w')) {

	MoveWidgetTo('u16', GetNum('120'), GetNum('110'),'none',500);

	var obj1 = document.getElementById("u5");
    obj1.focus();

SetWidgetFormText('u5', '');

}
else
if ((GetWidgetText('u5')) == ('s')) {

	MoveWidgetTo('u16', GetNum('120'), GetNum('210'),'none',500);

	var obj1 = document.getElementById("u5");
    obj1.focus();

SetWidgetFormText('u5', '');

}
else
if ((GetWidgetText('u5')) == ('a')) {

	MoveWidgetTo('u16', GetNum('70'), GetNum('160'),'none',500);

	var obj1 = document.getElementById("u5");
    obj1.focus();

SetWidgetFormText('u5', '');

}
else
if ((GetWidgetText('u5')) == ('d')) {

	MoveWidgetTo('u16', GetNum('170'), GetNum('160'),'none',500);

	var obj1 = document.getElementById("u5");
    obj1.focus();

SetWidgetFormText('u5', '');

}
else
if ((GetWidgetText('u5')) == ('z')) {

	MoveWidgetTo('u16', GetNum('120'), GetNum('160'),'none',500);

	var obj1 = document.getElementById("u5");
    obj1.focus();

SetWidgetFormText('u5', '');

}
});
gv_vAlignTable['u7'] = 'center';gv_vAlignTable['u9'] = 'center';