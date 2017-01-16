for(var i = 0; i < 67; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

if (true) {

SetGlobalVariableValue('Move', '0');

}

});
document.getElementById('u50_img').tabIndex = 0;

u50.style.cursor = 'pointer';
$axure.eventManager.click('u50', function(e) {

if ((GetGlobalVariableValue('Move')) == ('0')) {

	SetPanelState('u5', 'pd2u5','none','',500,'none','',500);

	MoveWidgetTo('u55', GetNum('38'), GetNum('205'),'none',500);

SetWidgetRichText('u58', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">当前是显示范围更精确的地图</span></p>');

SetGlobalVariableValue('Move', '1');

}
else
if ((GetGlobalVariableValue('Move')) == ('1')) {

	SetPanelState('u5', 'pd0u5','none','',500,'none','',500);

	MoveWidgetTo('u55', GetNum('38'), GetNum('189'),'none',500);

SetWidgetRichText('u58', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">当前是正常显示范围地图</span></p>');

SetGlobalVariableValue('Move', '0');

}
});
gv_vAlignTable['u51'] = 'center';gv_vAlignTable['u57'] = 'center';gv_vAlignTable['u58'] = 'top';
u59.style.cursor = 'pointer';
$axure.eventManager.click('u59', function(e) {

if (true) {

	SetPanelVisibility('u61','hidden','none',500);

}
});

$axure.eventManager.mouseover('u21', function(e) {
if (!IsTrueMouseOver('u21',e)) return;
if (true) {

	SetPanelVisibility('u23','','none',500);

}
});

$axure.eventManager.mouseout('u21', function(e) {
if (!IsTrueMouseOut('u21',e)) return;
if (true) {

	SetPanelVisibility('u23','hidden','none',500);

}
});
gv_vAlignTable['u22'] = 'center';document.getElementById('u24_img').tabIndex = 0;

u24.style.cursor = 'pointer';
$axure.eventManager.click('u24', function(e) {

if (true) {
function waitud3b8c53b08d74f619ec1e496bcbcdf041() {

	MoveWidgetTo('u20', GetNum('-74'), GetNum('-31'),'none',500);
function waitu7291488d71d94556ac350f27579939831() {

	MoveWidgetTo('u20', GetNum('-74'), GetNum('0'),'none',500);
}
setTimeout(waitu7291488d71d94556ac350f27579939831, 500);
}
setTimeout(waitud3b8c53b08d74f619ec1e496bcbcdf041, 500);

}
});
gv_vAlignTable['u25'] = 'center';document.getElementById('u26_img').tabIndex = 0;

u26.style.cursor = 'pointer';
$axure.eventManager.click('u26', function(e) {

if (true) {
function waitu17ecc0fd38c0479a9a22676e864a33961() {

	MoveWidgetTo('u20', GetNum('-74'), GetNum('-60'),'none',500);
function waitu6df069bbabce4f6f8e95d40726ecad921() {

	MoveWidgetTo('u20', GetNum('-74'), GetNum('-120'),'none',500);
}
setTimeout(waitu6df069bbabce4f6f8e95d40726ecad921, 500);
}
setTimeout(waitu17ecc0fd38c0479a9a22676e864a33961, 500);

}
});
gv_vAlignTable['u27'] = 'center';document.getElementById('u28_img').tabIndex = 0;

u28.style.cursor = 'pointer';
$axure.eventManager.click('u28', function(e) {

if (true) {
function waitu1f1125138e04489f8290bfa528fd90ae1() {

	MoveWidgetTo('u20', GetNum('-37'), GetNum('-62'),'none',500);
function waituc579267bbcc3439d9b4b1a5fa7fa85691() {

	MoveWidgetTo('u20', GetNum('0'), GetNum('-62'),'none',500);
}
setTimeout(waituc579267bbcc3439d9b4b1a5fa7fa85691, 500);
}
setTimeout(waitu1f1125138e04489f8290bfa528fd90ae1, 500);

}
});
gv_vAlignTable['u29'] = 'center';gv_vAlignTable['u63'] = 'center';gv_vAlignTable['u65'] = 'center';document.getElementById('u30_img').tabIndex = 0;

u30.style.cursor = 'pointer';
$axure.eventManager.click('u30', function(e) {

if (true) {
function waitubf428ca5f2614e31a9650d2be0c5d5411() {

	MoveWidgetTo('u20', GetNum('-112'), GetNum('-62'),'none',500);
function waituc1356c2490cc4b75b2b312428b63a0e61() {

	MoveWidgetTo('u20', GetNum('-150'), GetNum('-62'),'none',500);
}
setTimeout(waituc1356c2490cc4b75b2b312428b63a0e61, 500);
}
setTimeout(waitubf428ca5f2614e31a9650d2be0c5d5411, 500);

}
});
gv_vAlignTable['u31'] = 'center';document.getElementById('u32_img').tabIndex = 0;

u32.style.cursor = 'pointer';
$axure.eventManager.click('u32', function(e) {

if (true) {

	MoveWidgetTo('u20', GetNum('-74'), GetNum('-62'),'none',500);

}
});
gv_vAlignTable['u33'] = 'center';
$axure.eventManager.mouseover('u35', function(e) {
if (!IsTrueMouseOver('u35',e)) return;
if (true) {

	SetPanelVisibility('u37','','none',500);

}
});

$axure.eventManager.mouseout('u35', function(e) {
if (!IsTrueMouseOut('u35',e)) return;
if (true) {

	SetPanelVisibility('u37','hidden','none',500);

}
});
gv_vAlignTable['u36'] = 'center';document.getElementById('u38_img').tabIndex = 0;

u38.style.cursor = 'pointer';
$axure.eventManager.click('u38', function(e) {

if (true) {
function waitu7f953eff022d4ae78d34fb7c237be12f1() {

	MoveWidgetTo('u34', GetNum('-74'), GetNum('-31'),'none',500);
function waitub2deac50b4b64ef68184aabb3b41c89b1() {

	MoveWidgetTo('u34', GetNum('-74'), GetNum('0'),'none',500);
}
setTimeout(waitub2deac50b4b64ef68184aabb3b41c89b1, 500);
}
setTimeout(waitu7f953eff022d4ae78d34fb7c237be12f1, 500);

}
});
gv_vAlignTable['u39'] = 'center';u1.tabIndex = 0;

u1.style.cursor = 'pointer';
$axure.eventManager.click('u1', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第11集_下拉菜单联动.html');

}
});
gv_vAlignTable['u1'] = 'top';u2.tabIndex = 0;

u2.style.cursor = 'pointer';
$axure.eventManager.click('u2', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('_13__Symbian___.html');

}
});
gv_vAlignTable['u2'] = 'top';u3.tabIndex = 0;

u3.style.cursor = 'pointer';
$axure.eventManager.click('u3', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('首页.html');

}
});
gv_vAlignTable['u3'] = 'top';gv_vAlignTable['u41'] = 'center';document.getElementById('u42_img').tabIndex = 0;

u42.style.cursor = 'pointer';
$axure.eventManager.click('u42', function(e) {

if (true) {
function waitu4356a7a102cb42f18a941c09c7c282881() {

	MoveWidgetTo('u34', GetNum('-37'), GetNum('-62'),'none',500);
function waituba72d780077b4e66bfc12a7b0764ca101() {

	MoveWidgetTo('u34', GetNum('0'), GetNum('-62'),'none',500);
}
setTimeout(waituba72d780077b4e66bfc12a7b0764ca101, 500);
}
setTimeout(waitu4356a7a102cb42f18a941c09c7c282881, 500);

}
});
document.getElementById('u40_img').tabIndex = 0;

u40.style.cursor = 'pointer';
$axure.eventManager.click('u40', function(e) {

if (true) {
function waituf3ff0ddc290348e5878840d0ee0f67841() {

	MoveWidgetTo('u34', GetNum('-74'), GetNum('-60'),'none',500);
function waitu4b602f91d9e34cbc8e1d14818fb52c2f1() {

	MoveWidgetTo('u34', GetNum('-74'), GetNum('-120'),'none',500);
}
setTimeout(waitu4b602f91d9e34cbc8e1d14818fb52c2f1, 500);
}
setTimeout(waituf3ff0ddc290348e5878840d0ee0f67841, 500);

}
});
document.getElementById('u44_img').tabIndex = 0;

u44.style.cursor = 'pointer';
$axure.eventManager.click('u44', function(e) {

if (true) {
function waitud874f0917be04b6cb1856cad949081b01() {

	MoveWidgetTo('u34', GetNum('-112'), GetNum('-62'),'none',500);
function waitu55268152f466437498468754f97da6d41() {

	MoveWidgetTo('u34', GetNum('-150'), GetNum('-62'),'none',500);
}
setTimeout(waitu55268152f466437498468754f97da6d41, 500);
}
setTimeout(waitud874f0917be04b6cb1856cad949081b01, 500);

}
});
gv_vAlignTable['u45'] = 'center';gv_vAlignTable['u43'] = 'center';gv_vAlignTable['u47'] = 'center';document.getElementById('u48_img').tabIndex = 0;

u48.style.cursor = 'pointer';
$axure.eventManager.click('u48', function(e) {

if ((GetGlobalVariableValue('Move')) == ('0')) {

	SetPanelState('u5', 'pd1u5','none','',500,'none','',500);

	MoveWidgetTo('u55', GetNum('38'), GetNum('170'),'none',500);

SetWidgetRichText('u58', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">当前是显示范围更广泛的地图</span></p>');

SetGlobalVariableValue('Move', '1');

}
else
if ((GetGlobalVariableValue('Move')) == ('1')) {

	SetPanelState('u5', 'pd0u5','none','',500,'none','',500);

	MoveWidgetTo('u55', GetNum('38'), GetNum('189'),'none',500);

SetWidgetRichText('u58', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">当前是正常显示范围地图</span></p>');

SetGlobalVariableValue('Move', '0');

}
});
document.getElementById('u46_img').tabIndex = 0;

u46.style.cursor = 'pointer';
$axure.eventManager.click('u46', function(e) {

if (true) {

	MoveWidgetTo('u34', GetNum('-74'), GetNum('-62'),'none',500);

}
});

$axure.eventManager.mouseover('u7', function(e) {
if (!IsTrueMouseOver('u7',e)) return;
if (true) {

	SetPanelVisibility('u9','','none',500);

}
});

$axure.eventManager.mouseout('u7', function(e) {
if (!IsTrueMouseOut('u7',e)) return;
if (true) {

	SetPanelVisibility('u9','hidden','none',500);

}
});
gv_vAlignTable['u8'] = 'center';gv_vAlignTable['u49'] = 'center';document.getElementById('u10_img').tabIndex = 0;

u10.style.cursor = 'pointer';
$axure.eventManager.click('u10', function(e) {

if (true) {
function waitu78a93ed56e354d18b0dbcf7fff287dfc1() {

	MoveWidgetTo('u6', GetNum('-74'), GetNum('-31'),'none',500);
function waitu3adfd14cb302427eb0ee714b63143a7a1() {

	MoveWidgetTo('u6', GetNum('-74'), GetNum('0'),'none',500);
}
setTimeout(waitu3adfd14cb302427eb0ee714b63143a7a1, 500);
}
setTimeout(waitu78a93ed56e354d18b0dbcf7fff287dfc1, 500);

}
});
gv_vAlignTable['u11'] = 'center';document.getElementById('u12_img').tabIndex = 0;

u12.style.cursor = 'pointer';
$axure.eventManager.click('u12', function(e) {

if (true) {
function waitue17a205bb5a74e78902b88ebee4b5acf1() {

	MoveWidgetTo('u6', GetNum('-74'), GetNum('-60'),'none',500);
function waitu38d8c2c2d56a497a8b6fc9f9807c9dde1() {

	MoveWidgetTo('u6', GetNum('-74'), GetNum('-120'),'none',500);
}
setTimeout(waitu38d8c2c2d56a497a8b6fc9f9807c9dde1, 500);
}
setTimeout(waitue17a205bb5a74e78902b88ebee4b5acf1, 500);

}
});
gv_vAlignTable['u13'] = 'center';document.getElementById('u14_img').tabIndex = 0;

u14.style.cursor = 'pointer';
$axure.eventManager.click('u14', function(e) {

if (true) {
function waitu707ec3a2b67745e18a51f03a241a8fba1() {

	MoveWidgetTo('u6', GetNum('-37'), GetNum('-62'),'none',500);
function waituf4b674a9db9d4fa395b323ba3be773081() {

	MoveWidgetTo('u6', GetNum('0'), GetNum('-62'),'none',500);
}
setTimeout(waituf4b674a9db9d4fa395b323ba3be773081, 500);
}
setTimeout(waitu707ec3a2b67745e18a51f03a241a8fba1, 500);

}
});
gv_vAlignTable['u15'] = 'center';document.getElementById('u16_img').tabIndex = 0;

u16.style.cursor = 'pointer';
$axure.eventManager.click('u16', function(e) {

if (true) {
function waitu505952ba80cf45118692201c391f408f1() {

	MoveWidgetTo('u6', GetNum('-112'), GetNum('-62'),'none',500);
function waitu0682f8ed262f47fcad69776459a87b701() {

	MoveWidgetTo('u6', GetNum('-150'), GetNum('-62'),'none',500);
}
setTimeout(waitu0682f8ed262f47fcad69776459a87b701, 500);
}
setTimeout(waitu505952ba80cf45118692201c391f408f1, 500);

}
});
gv_vAlignTable['u17'] = 'center';document.getElementById('u18_img').tabIndex = 0;

u18.style.cursor = 'pointer';
$axure.eventManager.click('u18', function(e) {

if (true) {

	MoveWidgetTo('u6', GetNum('-74'), GetNum('-62'),'none',500);

}
});
gv_vAlignTable['u19'] = 'center';