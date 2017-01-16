for(var i = 0; i < 26; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

if (true) {

SetGlobalVariableValue('OnLoadVariable', '0');

}

});
gv_vAlignTable['u20'] = 'center';gv_vAlignTable['u17'] = 'top';gv_vAlignTable['u16'] = 'top';gv_vAlignTable['u15'] = 'center';
u10.style.cursor = 'pointer';
$axure.eventManager.click('u10', function(e) {

if (((GetWidgetText('u6')) == ('1@1.com')) && (((GetWidgetText('u7')) == ('123456')) && ((GetWidgetText('u12')) == ('KDEM')))) {

SetWidgetRichText('u21', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">亲爱的1@1.</span><span style="font-family:Arial;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">com</span><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;"></span></p><p style="text-align:left;"><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">您已经登录成功，谢谢体验</span></p>');

	SetPanelVisibility('u18','','none',500);

}
else
if (((GetWidgetText('u6')) == ('1@1.com')) && (((GetWidgetText('u7')) == ('123456')) && ((GetWidgetText('u12')) == ('GMSJ')))) {

SetWidgetRichText('u21', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">亲爱的1@1.</span><span style="font-family:Arial;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">com</span><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;"></span></p><p style="text-align:left;"><span style="font-family:Helvetica;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">您已经登录成功，谢谢体验</span></p>');

	SetPanelVisibility('u18','','none',500);

}
else
if (((GetWidgetText('u6')) == ('1@1.com')) && (((GetWidgetText('u7')) == ('123456')) && ((GetWidgetText('u12')) != ('GMSJ')))) {

SetWidgetRichText('u17', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FF2600;">你填写的验证码有误，请核实大小写后输入</span></p>');

}
else
if (((GetWidgetText('u6')) == ('1@1.com')) && (((GetWidgetText('u7')) == ('123456')) && ((GetWidgetText('u12')) != ('KDEM')))) {

SetWidgetRichText('u17', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FF2600;">你填写的验证码有误，请核实大小写后输入</span></p>');

}
else
if (((GetWidgetText('u6')) != ('1@1.com')) || ((GetWidgetText('u7')) != ('123456'))) {

SetWidgetRichText('u17', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FF2600;">你填写的用户名或密码有误，请核实后输入</span></p>');

}
});
gv_vAlignTable['u11'] = 'top';
$axure.eventManager.focus('u12', function(e) {

if (true) {

SetWidgetFormText('u12', '');

SetWidgetRichText('u17', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

}
});

$axure.eventManager.blur('u12', function(e) {

if ((GetWidgetValueLength('u12')) == ('0')) {

SetWidgetFormText('u12', '输入右侧验证码');

}
});
u13.tabIndex = 0;

u13.style.cursor = 'pointer';
$axure.eventManager.click('u13', function(e) {

if ((GetGlobalVariableValue('OnLoadVariable')) == ('0')) {

SetWidgetRichText('u16', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:bold;font-style:normal;text-decoration:none;color:#FFA900;">GMSJ</span></p>');

SetGlobalVariableValue('OnLoadVariable', '1');

}
else
if ((GetGlobalVariableValue('OnLoadVariable')) == ('1')) {

SetWidgetRichText('u16', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:bold;font-style:normal;text-decoration:none;color:#FFA900;">KDEM</span></p>');

SetGlobalVariableValue('OnLoadVariable', '0');

}
});
gv_vAlignTable['u13'] = 'top';u0.tabIndex = 0;

u0.style.cursor = 'pointer';
$axure.eventManager.click('u0', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第7集_联想搜索框.html');

}
});
gv_vAlignTable['u0'] = 'top';u1.tabIndex = 0;

u1.style.cursor = 'pointer';
$axure.eventManager.click('u1', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第9集_注册.html');

}
});
gv_vAlignTable['u1'] = 'top';u2.tabIndex = 0;

u2.style.cursor = 'pointer';
$axure.eventManager.click('u2', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('首页.html');

}
});
gv_vAlignTable['u2'] = 'top';gv_vAlignTable['u5'] = 'center';
$axure.eventManager.focus('u6', function(e) {

if (true) {

SetWidgetFormText('u6', '');

SetWidgetRichText('u17', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

}
});

$axure.eventManager.blur('u6', function(e) {

if ((GetWidgetValueLength('u6')) == ('0')) {

SetWidgetFormText('u6', '请输入用户名');

}
});

$axure.eventManager.focus('u7', function(e) {

if (true) {

SetWidgetFormText('u7', '');

SetWidgetRichText('u17', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

}
});

$axure.eventManager.blur('u7', function(e) {

if ((GetWidgetValueLength('u7')) == ('0')) {

SetWidgetFormText('u7', '请输入密码');

}
});
gv_vAlignTable['u8'] = 'top';gv_vAlignTable['u9'] = 'top';gv_vAlignTable['u21'] = 'top';
u22.style.cursor = 'pointer';
$axure.eventManager.click('u22', function(e) {

if (true) {

SetWidgetFormText('u6', '请输入用户名');

SetWidgetFormText('u7', '请输入密码');

SetWidgetFormText('u12', '输入右侧验证码');

SetGlobalVariableValue('OnLoadVariable', '0');

	SetPanelVisibility('u18','hidden','none',500);

}
});
gv_vAlignTable['u24'] = 'center';