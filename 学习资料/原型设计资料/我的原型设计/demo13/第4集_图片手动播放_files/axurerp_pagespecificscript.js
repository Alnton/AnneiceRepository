for(var i = 0; i < 17; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});
gv_vAlignTable['u15'] = 'center';
$axure.eventManager.mouseover('u10', function(e) {
if (!IsTrueMouseOver('u10',e)) return;
if (true) {

SetWidgetRichText('u5', '<p style="text-align:center;"><span style="font-family:Helvetica;font-size:37px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">图3</span></p>');

SetWidgetSelected('u10');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u6');
SetWidgetNotSelected('u12');
}
});

$axure.eventManager.mouseout('u10', function(e) {
if (!IsTrueMouseOut('u10',e)) return;
if (true) {

SetWidgetNotSelected('u10');
}
});
gv_vAlignTable['u11'] = 'center';
$axure.eventManager.mouseover('u12', function(e) {
if (!IsTrueMouseOver('u12',e)) return;
if (true) {

SetWidgetRichText('u5', '<p style="text-align:center;"><span style="font-family:Helvetica;font-size:37px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">图4</span></p>');

SetWidgetSelected('u12');
SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
}
});

$axure.eventManager.mouseout('u12', function(e) {
if (!IsTrueMouseOut('u12',e)) return;
if (true) {

SetWidgetNotSelected('u12');
}
});
gv_vAlignTable['u13'] = 'center';u0.tabIndex = 0;

u0.style.cursor = 'pointer';
$axure.eventManager.click('u0', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第3集_图片墙.html');

}
});
gv_vAlignTable['u0'] = 'top';u1.tabIndex = 0;

u1.style.cursor = 'pointer';
$axure.eventManager.click('u1', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第5集_图片自动播放.html');

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
$axure.eventManager.mouseover('u6', function(e) {
if (!IsTrueMouseOver('u6',e)) return;
if (true) {

SetWidgetRichText('u5', '<p style="text-align:center;"><span style="font-family:Helvetica;font-size:37px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">图1</span></p>');

SetWidgetSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u12');
}
});

$axure.eventManager.mouseout('u6', function(e) {
if (!IsTrueMouseOut('u6',e)) return;
if (true) {

SetWidgetNotSelected('u6');
}
});
gv_vAlignTable['u7'] = 'center';
$axure.eventManager.mouseover('u8', function(e) {
if (!IsTrueMouseOver('u8',e)) return;
if (true) {

SetWidgetRichText('u5', '<p style="text-align:center;"><span style="font-family:Helvetica;font-size:37px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">图2</span></p>');

SetWidgetSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u6');
}
});

$axure.eventManager.mouseout('u8', function(e) {
if (!IsTrueMouseOut('u8',e)) return;
if (true) {

SetWidgetNotSelected('u8');
}
});
gv_vAlignTable['u9'] = 'center';