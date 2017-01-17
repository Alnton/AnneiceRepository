for(var i = 0; i < 35; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});
gv_vAlignTable['u20'] = 'top';gv_vAlignTable['u23'] = 'center';gv_vAlignTable['u26'] = 'center';gv_vAlignTable['u29'] = 'center';gv_vAlignTable['u30'] = 'top';
u31.style.cursor = 'pointer';
$axure.eventManager.click('u31', function(e) {

if (true) {

SetWidgetFormText('u10', '');

SetWidgetFormText('u11', '');

SetWidgetFormText('u12', '');

	SetPanelVisibility('u2','hidden','none',500);

	SetPanelVisibility('u17','hidden','none',500);

	SetPanelVisibility('u21','hidden','none',500);

	SetPanelVisibility('u24','hidden','none',500);

	SetPanelVisibility('u27','hidden','none',500);

}
});
gv_vAlignTable['u33'] = 'center';gv_vAlignTable['u1'] = 'center';gv_vAlignTable['u4'] = 'center';gv_vAlignTable['u5'] = 'top';u6.tabIndex = 0;

u6.style.cursor = 'pointer';
$axure.eventManager.click('u6', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第8集_登录验证.html');

}
});
gv_vAlignTable['u6'] = 'top';u7.tabIndex = 0;

u7.style.cursor = 'pointer';
$axure.eventManager.click('u7', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第10集_微博大家正在说.html');

}
});
gv_vAlignTable['u7'] = 'top';u8.tabIndex = 0;

u8.style.cursor = 'pointer';
$axure.eventManager.click('u8', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('首页.html');

}
});
gv_vAlignTable['u8'] = 'top';
$axure.eventManager.focus('u10', function(e) {

if (true) {

SetWidgetFormText('u10', '');

SetWidgetRichText('u5', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">用户名为任意长度的数字字母组合</span></p>');

	SetPanelVisibility('u2','','none',500);

	MoveWidgetTo('u2', GetNum('50'), GetNum('72'),'none',500);

}
});

$axure.eventManager.keyup('u11', function(e) {

if ((GetWidgetValueLength('u11')) <= Number('4')) {

	SetPanelVisibility('u17','','none',500);

}
else
if (((GetWidgetValueLength('u11')) > Number('4')) && ((GetWidgetValueLength('u11')) <= Number('8'))) {

	SetPanelVisibility('u17','','none',500);

	SetPanelVisibility('u21','','none',500);

}
else
if ((GetWidgetValueLength('u11')) > Number('8')) {

	SetPanelVisibility('u17','','none',500);

	SetPanelVisibility('u21','','none',500);

	SetPanelVisibility('u24','','none',500);

}
});

$axure.eventManager.focus('u11', function(e) {

if (true) {

SetWidgetRichText('u5', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">请输入密码，密码可以是数字和字母组合</span></p>');

	SetPanelVisibility('u2','','none',500);

	MoveWidgetTo('u2', GetNum('50'), GetNum('142'),'none',500);

}
});

$axure.eventManager.focus('u12', function(e) {

if (true) {

SetWidgetFormText('u12', '');

SetWidgetRichText('u5', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">重复输入刚才的密码</span></p>');

	SetPanelVisibility('u2','','none',500);

	MoveWidgetTo('u2', GetNum('50'), GetNum('216'),'none',500);

}
});

u13.style.cursor = 'pointer';
$axure.eventManager.click('u13', function(e) {

if (((GetWidgetText('u11')) == (GetWidgetText('u12'))) && ((GetWidgetValueLength('u10')) > Number('0'))) {

SetGlobalVariableValue('OnLoadVariable', GetWidgetText('u10'));

SetWidgetRichText('u30', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">亲爱的' + (GetGlobalVariableValue('OnLoadVariable')) + '</span></p><p style="text-align:left;"><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">您已经注册成功，谢谢体验</span></p>');

	SetPanelVisibility('u27','','none',500);

}
else
if ((GetWidgetText('u11')) != (GetWidgetText('u12'))) {

SetWidgetRichText('u5', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FF2600;">两次密码不一致，请重新输入</span></p>');

SetWidgetFormText('u11', '');

SetWidgetFormText('u12', '');

	SetPanelVisibility('u2','','none',500);

	SetPanelVisibility('u17','hidden','none',500);

	SetPanelVisibility('u21','hidden','none',500);

	SetPanelVisibility('u24','hidden','none',500);

	MoveWidgetTo('u2', GetNum('50'), GetNum('142'),'none',500);

}

if ((GetWidgetValueLength('u10')) == ('0')) {

SetWidgetRichText('u5', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FF2600;">请输入用户名</span></p>');

SetWidgetFormText('u11', '');

SetWidgetFormText('u12', '');

SetWidgetFormText('u10', '');

	SetPanelVisibility('u2','','none',500);

	SetPanelVisibility('u17','hidden','none',500);

	SetPanelVisibility('u21','hidden','none',500);

	SetPanelVisibility('u24','hidden','none',500);

	MoveWidgetTo('u2', GetNum('50'), GetNum('72'),'none',500);

}
});
gv_vAlignTable['u14'] = 'top';gv_vAlignTable['u15'] = 'top';gv_vAlignTable['u16'] = 'top';gv_vAlignTable['u19'] = 'center';