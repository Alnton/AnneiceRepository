for(var i = 0; i < 19; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});
gv_vAlignTable['u17'] = 'center';
$axure.eventManager.mouseover('u15', function(e) {
if (!IsTrueMouseOver('u15',e)) return;
if (true) {

	MoveWidgetTo('u8', GetNum('0'), GetNum('80'),'none',500);

}
});
gv_vAlignTable['u15'] = 'top';gv_vAlignTable['u10'] = 'center';
$axure.eventManager.mouseover('u11', function(e) {
if (!IsTrueMouseOver('u11',e)) return;
if (true) {

	MoveWidgetTo('u8', GetNum('0'), GetNum('0'),'none',500);

}
});
gv_vAlignTable['u11'] = 'top';
$axure.eventManager.mouseover('u12', function(e) {
if (!IsTrueMouseOver('u12',e)) return;
if (true) {

	MoveWidgetTo('u8', GetNum('0'), GetNum('20'),'none',500);

}
});
gv_vAlignTable['u12'] = 'top';
$axure.eventManager.mouseover('u13', function(e) {
if (!IsTrueMouseOver('u13',e)) return;
if (true) {

	MoveWidgetTo('u8', GetNum('0'), GetNum('40'),'none',500);

}
});
gv_vAlignTable['u13'] = 'top';
$axure.eventManager.mouseover('u14', function(e) {
if (!IsTrueMouseOver('u14',e)) return;
if (true) {

	MoveWidgetTo('u8', GetNum('0'), GetNum('60'),'none',500);

}
});
gv_vAlignTable['u14'] = 'top';u0.tabIndex = 0;

u0.style.cursor = 'pointer';
$axure.eventManager.click('u0', function(e) {

if (true) {

	self.location.href='#';

}
});
gv_vAlignTable['u0'] = 'top';u1.tabIndex = 0;

u1.style.cursor = 'pointer';
$axure.eventManager.click('u1', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第8集_登录验证.html');

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
$axure.eventManager.keyup('u4', function(e) {

if ((GetWidgetValueLength('u4')) > Number('0')) {

	SetPanelVisibility('u5','','none',500);

SetGlobalVariableValue('OnLoadVariable', GetWidgetText('u4'));

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">' + (GetGlobalVariableValue('OnLoadVariable')) + '******</span></p>');

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">' + (GetGlobalVariableValue('OnLoadVariable')) + '......</span></p>');

SetWidgetRichText('u13', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">' + (GetGlobalVariableValue('OnLoadVariable')) + '------</span></p>');

SetWidgetRichText('u14', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">' + (GetGlobalVariableValue('OnLoadVariable')) + '~~~~~~</span></p>');

SetWidgetRichText('u15', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">' + (GetGlobalVariableValue('OnLoadVariable')) + '?????</span></p>');

}
else
if ((GetWidgetValueLength('u4')) == ('0')) {

	SetPanelVisibility('u5','hidden','none',500);

}
});
gv_vAlignTable['u7'] = 'center';