for(var i = 0; i < 133; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

if (true) {

SetGlobalVariableValue('menu', '0');
function waituee02b0a2946f484da6b5f60b972138001() {

SetWidgetRichText('u105', '<p style="text-align:center;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FEFFFE;">系统提示文字1</span></p>');
function waitueb8518b4c93a4bdf804dfdb413fe024c1() {

SetWidgetRichText('u105', '<p style="text-align:center;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FEFFFE;">系统帮助文字1</span></p>');
function waitu5dcfef2a38814097aec468abd85be0031() {

	SetPanelState('u54', 'pd1u54','none','',500,'none','',500);
}
setTimeout(waitu5dcfef2a38814097aec468abd85be0031, 1000);
}
setTimeout(waitueb8518b4c93a4bdf804dfdb413fe024c1, 1000);
}
setTimeout(waituee02b0a2946f484da6b5f60b972138001, 1000);

}

});
gv_vAlignTable['u59'] = 'top';u80.tabIndex = 0;

u80.style.cursor = 'pointer';
$axure.eventManager.click('u80', function(e) {

if ((GetGlobalVariableValue('menu')) == ('0')) {

SetWidgetRichText('u80', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选择</span></p>');

SetGlobalVariableValue('menu', '1');

SetWidgetRichText('u81', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">取消</span></p>');

SetGlobalVariableValue('OnLoadVariable', '0');

	SetPanelVisibility('u82','','none',500);

}
else
if ((GetGlobalVariableValue('menu')) == ('1')) {

}
});
gv_vAlignTable['u80'] = 'top';u81.tabIndex = 0;

u81.style.cursor = 'pointer';
$axure.eventManager.click('u81', function(e) {

if ((GetGlobalVariableValue('menu')) == ('0')) {

	SetPanelState('u106', 'pd1u106','none','',500,'none','',500);

	SetPanelVisibility('u106','','none',500);

}
else
if ((GetGlobalVariableValue('menu')) == ('1')) {

SetGlobalVariableValue('menu', '0');

SetWidgetRichText('u80', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选项</span></p>');

SetWidgetRichText('u81', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">退出</span></p>');

SetGlobalVariableValue('OnLoadVariable', '1');

	SetPanelVisibility('u82','hidden','none',500);

}
});
gv_vAlignTable['u81'] = 'top';document.getElementById('u85_img').tabIndex = 0;

u85.style.cursor = 'pointer';
$axure.eventManager.click('u85', function(e) {

if (true) {

SetGlobalVariableValue('menu', '0');

	SetPanelState('u54', 'pd2u54','none','',500,'none','',500);

	SetPanelVisibility('u82','hidden','none',500);

}
});
gv_vAlignTable['u86'] = 'top';gv_vAlignTable['u88'] = 'top';document.getElementById('u89_img').tabIndex = 0;

u89.style.cursor = 'pointer';
$axure.eventManager.click('u89', function(e) {

if (true) {

	SetPanelState('u106', 'pd0u106','none','',500,'none','',500);

	SetPanelVisibility('u106','','none',500);

	SetPanelVisibility('u82','hidden','none',500);

}
});
gv_vAlignTable['u90'] = 'top';document.getElementById('u91_img').tabIndex = 0;

u91.style.cursor = 'pointer';
$axure.eventManager.click('u91', function(e) {

if (true) {

	SetPanelState('u106', 'pd1u106','none','',500,'none','',500);

	SetPanelVisibility('u106','','none',500);

	SetPanelVisibility('u82','hidden','none',500);

}
});
gv_vAlignTable['u92'] = 'top';document.getElementById('u12_img').tabIndex = 0;
HookHover('u12', false);
HookClick('u12', false);

u12.style.cursor = 'pointer';
$axure.eventManager.click('u12', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u13'] = 'center';document.getElementById('u14_img').tabIndex = 0;
HookHover('u14', false);
HookClick('u14', false);

u14.style.cursor = 'pointer';
$axure.eventManager.click('u14', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
document.getElementById('u10_img').tabIndex = 0;
HookHover('u10', false);
HookClick('u10', false);

u10.style.cursor = 'pointer';
$axure.eventManager.click('u10', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
document.getElementById('u16_img').tabIndex = 0;
HookHover('u16', false);
HookClick('u16', false);

u16.style.cursor = 'pointer';
$axure.eventManager.click('u16', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u17'] = 'center';document.getElementById('u18_img').tabIndex = 0;
HookHover('u18', false);
HookClick('u18', false);

u18.style.cursor = 'pointer';
$axure.eventManager.click('u18', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u19'] = 'center';gv_vAlignTable['u111'] = 'top';u112.tabIndex = 0;

u112.style.cursor = 'pointer';
$axure.eventManager.click('u112', function(e) {

if (true) {

	parent.window.close();

}
});
gv_vAlignTable['u112'] = 'top';u113.tabIndex = 0;

u113.style.cursor = 'pointer';
$axure.eventManager.click('u113', function(e) {

if (true) {

SetGlobalVariableValue('menu', '0');

SetWidgetRichText('u80', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选项</span></p>');

SetWidgetRichText('u81', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">退出</span></p>');

	SetPanelVisibility('u82','hidden','none',500);

	SetPanelVisibility('u106','hidden','none',500);

}
});
gv_vAlignTable['u113'] = 'top';gv_vAlignTable['u115'] = 'center';document.getElementById('u20_img').tabIndex = 0;
HookHover('u20', false);
HookClick('u20', false);

u20.style.cursor = 'pointer';
$axure.eventManager.click('u20', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u21'] = 'center';document.getElementById('u22_img').tabIndex = 0;
HookHover('u22', false);
HookClick('u22', false);

u22.style.cursor = 'pointer';
$axure.eventManager.click('u22', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u23'] = 'top';document.getElementById('u24_img').tabIndex = 0;
HookHover('u24', false);
HookClick('u24', false);

u24.style.cursor = 'pointer';
$axure.eventManager.click('u24', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u25'] = 'center';document.getElementById('u26_img').tabIndex = 0;

u26.style.cursor = 'pointer';
$axure.eventManager.click('u26', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u27'] = 'center';document.getElementById('u28_img').tabIndex = 0;
HookHover('u28', false);
HookClick('u28', false);

u28.style.cursor = 'pointer';
$axure.eventManager.click('u28', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u29'] = 'center';gv_vAlignTable['u100'] = 'center';gv_vAlignTable['u102'] = 'center';gv_vAlignTable['u104'] = 'center';gv_vAlignTable['u105'] = 'top';gv_vAlignTable['u108'] = 'center';u127.tabIndex = 0;

u127.style.cursor = 'pointer';
$axure.eventManager.click('u127', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第14集_仿Android手机交互.html');

}
});
gv_vAlignTable['u127'] = 'top';u128.tabIndex = 0;

u128.style.cursor = 'pointer';
$axure.eventManager.click('u128', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('首页.html');

}
});
gv_vAlignTable['u128'] = 'top';document.getElementById('u30_img').tabIndex = 0;
HookHover('u30', false);
HookClick('u30', false);

u30.style.cursor = 'pointer';
$axure.eventManager.click('u30', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u31'] = 'center';document.getElementById('u32_img').tabIndex = 0;
HookHover('u32', false);
HookClick('u32', false);

u32.style.cursor = 'pointer';
$axure.eventManager.click('u32', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u33'] = 'center';document.getElementById('u34_img').tabIndex = 0;
HookHover('u34', false);
HookClick('u34', false);

u34.style.cursor = 'pointer';
$axure.eventManager.click('u34', function(e) {

if ((GetGlobalVariableValue('OnLoadVariable')) == ('0')) {

	SetPanelState('u106', 'pd1u106','none','',500,'none','',500);

	SetPanelVisibility('u106','','none',500);

	SetPanelVisibility('u82','hidden','none',500);

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u35'] = 'center';document.getElementById('u36_img').tabIndex = 0;
HookHover('u36', false);
HookClick('u36', false);

u36.style.cursor = 'pointer';
$axure.eventManager.click('u36', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u37'] = 'center';document.getElementById('u38_img').tabIndex = 0;
HookHover('u38', false);
HookClick('u38', false);

u38.style.cursor = 'pointer';
$axure.eventManager.click('u38', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u39'] = 'center';gv_vAlignTable['u110'] = 'center';gv_vAlignTable['u96'] = 'top';gv_vAlignTable['u98'] = 'top';gv_vAlignTable['u116'] = 'top';gv_vAlignTable['u118'] = 'center';document.getElementById('u40_img').tabIndex = 0;
HookHover('u40', false);
HookClick('u40', false);

u40.style.cursor = 'pointer';
$axure.eventManager.click('u40', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u41'] = 'center';document.getElementById('u42_img').tabIndex = 0;
HookHover('u42', false);
HookClick('u42', false);

u42.style.cursor = 'pointer';
$axure.eventManager.click('u42', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u43'] = 'center';document.getElementById('u44_img').tabIndex = 0;

u44.style.cursor = 'pointer';
$axure.eventManager.click('u44', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u45'] = 'center';document.getElementById('u46_img').tabIndex = 0;

u46.style.cursor = 'pointer';
$axure.eventManager.click('u46', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u47'] = 'center';document.getElementById('u48_img').tabIndex = 0;
HookHover('u48', false);
HookClick('u48', false);

u48.style.cursor = 'pointer';
$axure.eventManager.click('u48', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetSelected('u48');
}
});
gv_vAlignTable['u49'] = 'center';gv_vAlignTable['u120'] = 'center';gv_vAlignTable['u121'] = 'top';u122.tabIndex = 0;

u122.style.cursor = 'pointer';
$axure.eventManager.click('u122', function(e) {

if (true) {

SetGlobalVariableValue('menu', '0');

SetWidgetRichText('u80', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选项</span></p>');

SetWidgetRichText('u81', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">退出</span></p>');

	SetPanelVisibility('u82','hidden','none',500);

	SetPanelVisibility('u106','hidden','none',500);

}
});
gv_vAlignTable['u122'] = 'top';gv_vAlignTable['u124'] = 'center';gv_vAlignTable['u125'] = 'top';u126.tabIndex = 0;

u126.style.cursor = 'pointer';
$axure.eventManager.click('u126', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第12集_查看地图.html');

}
});
gv_vAlignTable['u126'] = 'top';gv_vAlignTable['u1'] = 'center';gv_vAlignTable['u3'] = 'center';gv_vAlignTable['u5'] = 'center';document.getElementById('u6_img').tabIndex = 0;
HookHover('u6', false);
HookClick('u6', false);

u6.style.cursor = 'pointer';
$axure.eventManager.click('u6', function(e) {

if (true) {

SetWidgetSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u7'] = 'center';document.getElementById('u8_img').tabIndex = 0;
HookHover('u8', false);
HookClick('u8', false);

u8.style.cursor = 'pointer';
$axure.eventManager.click('u8', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u9'] = 'center';document.getElementById('u50_img').tabIndex = 0;

u50.style.cursor = 'pointer';
$axure.eventManager.click('u50', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetNotSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetSelected('u48');
}
});
gv_vAlignTable['u51'] = 'center';document.getElementById('u52_img').tabIndex = 0;

u52.style.cursor = 'pointer';
$axure.eventManager.click('u52', function(e) {

if (true) {

SetWidgetNotSelected('u6');
SetWidgetNotSelected('u8');
SetWidgetNotSelected('u10');
SetWidgetNotSelected('u14');
SetWidgetSelected('u12');
SetWidgetNotSelected('u16');
SetWidgetNotSelected('u18');
SetWidgetNotSelected('u20');
SetWidgetNotSelected('u22');
SetWidgetNotSelected('u24');
SetWidgetNotSelected('u28');
SetWidgetNotSelected('u30');
SetWidgetNotSelected('u32');
SetWidgetNotSelected('u34');
SetWidgetNotSelected('u36');
SetWidgetNotSelected('u38');
SetWidgetNotSelected('u40');
SetWidgetNotSelected('u42');
SetWidgetNotSelected('u48');
}
});
gv_vAlignTable['u53'] = 'center';gv_vAlignTable['u11'] = 'center';gv_vAlignTable['u56'] = 'center';u57.tabIndex = 0;

u57.style.cursor = 'pointer';
$axure.eventManager.click('u57', function(e) {

if ((GetGlobalVariableValue('menu')) == ('0')) {

SetWidgetRichText('u57', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选择</span></p>');

SetGlobalVariableValue('menu', '1');

SetWidgetRichText('u58', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">取消</span></p>');

	SetPanelVisibility('u60','','none',500);

}
else
if ((GetGlobalVariableValue('menu')) == ('1')) {

}
});
gv_vAlignTable['u57'] = 'top';u58.tabIndex = 0;

u58.style.cursor = 'pointer';
$axure.eventManager.click('u58', function(e) {

if ((GetGlobalVariableValue('menu')) == ('0')) {

SetGlobalVariableValue('menu', '0');

SetWidgetRichText('u80', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选项</span></p>');

SetWidgetRichText('u81', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">退出</span></p>');

	SetPanelState('u54', 'pd1u54','none','',500,'none','',500);

	SetPanelVisibility('u82','hidden','none',500);

}
else
if ((GetGlobalVariableValue('menu')) == ('1')) {

SetGlobalVariableValue('menu', '0');

SetWidgetRichText('u57', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选项</span></p>');

SetWidgetRichText('u58', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">返回</span></p>');

	SetPanelVisibility('u60','hidden','none',500);

}
});
gv_vAlignTable['u58'] = 'top';gv_vAlignTable['u15'] = 'center';gv_vAlignTable['u131'] = 'center';gv_vAlignTable['u64'] = 'top';gv_vAlignTable['u66'] = 'top';document.getElementById('u67_img').tabIndex = 0;

u67.style.cursor = 'pointer';
$axure.eventManager.click('u67', function(e) {

if (true) {

SetGlobalVariableValue('menu', '0');

SetWidgetRichText('u80', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选项</span></p>');

SetWidgetRichText('u81', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">退出</span></p>');

SetWidgetRichText('u57', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">选项</span></p>');

SetWidgetRichText('u58', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">返回</span></p>');

	SetPanelState('u54', 'pd1u54','none','',500,'none','',500);

	SetPanelVisibility('u82','hidden','none',500);

	SetPanelVisibility('u60','hidden','none',500);

}
});
gv_vAlignTable['u68'] = 'top';gv_vAlignTable['u70'] = 'center';gv_vAlignTable['u71'] = 'top';gv_vAlignTable['u73'] = 'center';gv_vAlignTable['u75'] = 'center';gv_vAlignTable['u77'] = 'center';gv_vAlignTable['u78'] = 'top';gv_vAlignTable['u79'] = 'top';