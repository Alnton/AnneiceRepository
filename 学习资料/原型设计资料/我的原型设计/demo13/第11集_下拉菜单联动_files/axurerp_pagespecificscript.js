for(var i = 0; i < 13; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});

$axure.eventManager.change('u10', function(e) {

if ((GetSelectedOption('u10')) == ('北京')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:21px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">今天夜间多云转晴16℃~11℃&nbsp; 明天白天晴20℃~10℃&nbsp; </span></p>');

}
else
if ((GetSelectedOption('u10')) != ('北京')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

}
});
gv_vAlignTable['u12'] = 'top';u0.tabIndex = 0;

u0.style.cursor = 'pointer';
$axure.eventManager.click('u0', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第10集_微博大家正在说.html');

}
});
gv_vAlignTable['u0'] = 'top';u1.tabIndex = 0;

u1.style.cursor = 'pointer';
$axure.eventManager.click('u1', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第12集_查看地图.html');

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
$axure.eventManager.change('u7', function(e) {

if ((GetSelectedOption('u7')) == ('--选择省份或直辖市--')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

	SetPanelState('u8', 'pd0u8','none','',500,'none','',500);

}
else
if ((GetSelectedOption('u7')) == ('北京')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

	SetPanelState('u8', 'pd1u8','none','',500,'none','',500);

}
else
if ((GetSelectedOption('u7')) == ('甘肃')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

	SetPanelState('u8', 'pd2u8','none','',500,'none','',500);

}
});
