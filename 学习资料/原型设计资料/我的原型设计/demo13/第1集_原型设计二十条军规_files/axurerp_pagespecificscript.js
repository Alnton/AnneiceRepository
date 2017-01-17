for(var i = 0; i < 16; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

if (true) {

SetGlobalVariableValue('Move', '1');

}

});
gv_vAlignTable['u15'] = 'top';gv_vAlignTable['u10'] = 'center';gv_vAlignTable['u11'] = 'top';gv_vAlignTable['u12'] = 'top';document.getElementById('u13_img').tabIndex = 0;

u13.style.cursor = 'pointer';
$axure.eventManager.click('u13', function(e) {

if ((GetGlobalVariableValue('Move')) == ('1')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">已经是第一条了！点击右箭头浏览下一条</span></p>');

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第一条：原型设计的最终目的是为了准确、方便、快捷的表达产品设计人员的产品设计意图；</span></p>');

}
else
if ((GetGlobalVariableValue('Move')) == ('2')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第二条：原型的观看者往往不是同一类对象，因此原型的设计不可避免的会有多种表现形态，每一种形态的原型都是为设计服务，没有高低之分；</span></p>');

SetGlobalVariableValue('Move', '1');

}
else
if ((GetGlobalVariableValue('Move')) == ('3')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第三条：如果按照产出方式，有手绘产出、软件产出之分,如果按照表现形式，有纸质、低保真、高保真之分；</span></p>');

SetGlobalVariableValue('Move', '2');

}
else
if ((GetGlobalVariableValue('Move')) == ('4')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第四条：如果你的产品设计周期中，原型设计时间过长，可能你需要停一下，站得远些重新审视一下自己原型设计的初衷；</span></p>');

SetGlobalVariableValue('Move', '3');

}
else
if ((GetGlobalVariableValue('Move')) == ('5')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第五条：原型是否要做到高交互、高仿真取决于观看者的需求和设计者的时间，如果简洁的原型已经完全满足观看者的需求，应该首选交互少的低保真原型，而不要过度沉浸在高交互、高仿真原型设计的快感中；</span></p>');

SetGlobalVariableValue('Move', '4');

}
else
if ((GetGlobalVariableValue('Move')) == ('6')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第六条：不要小瞧纸质原型，往往它会有磨刀不误砍柴工的功效，如果有条件，尽量不要省略，纸质原型最大的价值是思路的最初梳理和内部的多人讨论而不是自己一个人纸面画画就完成了纸质原型的阶段；</span></p>');

SetGlobalVariableValue('Move', '5');

}
else
if ((GetGlobalVariableValue('Move')) == ('7')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第七条：原型设计工具，精通一个比掌握十个更有价值，如果推荐原型工具，首选还是Axure；</span></p>');

SetGlobalVariableValue('Move', '6');

}
else
if ((GetGlobalVariableValue('Move')) == ('8')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第八条：没有人规定必须用Axure设计原型，最合适你的原型工具就是最好的；</span></p>');

SetGlobalVariableValue('Move', '7');

}
else
if ((GetGlobalVariableValue('Move')) == ('9')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第九条：原型是用来正确表达产品设计思想的工具，而不是掌握了原型工具就能正确的表达产品设计思想；</span></p>');

SetGlobalVariableValue('Move', '8');

}
else
if ((GetGlobalVariableValue('Move')) == ('10')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十条：不要像维护自己的颜面一样维护原型的设计，相反原型的价值就是要被不断的修改、推翻、打磨、锤炼,要有颠覆整个原型初稿，重新设计的气魄和担当；</span></p>');

SetGlobalVariableValue('Move', '9');

}
else
if ((GetGlobalVariableValue('Move')) == ('11')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十一条：谁都可能遇到一个不懂产品设计的领导对你的原型指指点点，尝试去理解他的真正意图，并将他喜欢的方式和你坚持的方式都表现出来，只要是正确的体验方式，用户是会给出最终的投票；</span></p>');

SetGlobalVariableValue('Move', '10');

}
else
if ((GetGlobalVariableValue('Move')) == ('12')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十二条：Axure不止可以设计Web原型，正解：Axure可以设计Web、Wap、PC客户端、手机客户端、IPAD……各种平台和终端上的应用；</span></p>');

SetGlobalVariableValue('Move', '11');

}
else
if ((GetGlobalVariableValue('Move')) == ('13')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十三条：提高自己Axure技能的最好方式，模仿你喜欢的交互实例，如:IPhone、Android手机、微博、IM、SNS……；只要你能认真模仿下来，你会发现收获的不止是Axure技能，你的产品设计思想也会进步不小；</span></p>');

SetGlobalVariableValue('Move', '12');

}
else
if ((GetGlobalVariableValue('Move')) == ('14')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十四条：不要在是否研究Axure技巧上犹豫不决或者争论不休，正确的做法：掌握你需要的技巧，并在设计原型中使用；优秀的做法：掌握所有的Axure技能，并在设计原型中按需使用；</span></p>');

SetGlobalVariableValue('Move', '13');

}
else
if ((GetGlobalVariableValue('Move')) == ('15')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十五条：掌握Axure技能并不能证明你就是一个合格的产品设计者，但要想成为一名优秀的产品设计者应该掌握Axure；</span></p>');

SetGlobalVariableValue('Move', '14');

}
else
if ((GetGlobalVariableValue('Move')) == ('16')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十六条：做流程图和产出PRD文档是Axure的功能之一，但不要作为首选，让工具发挥它最擅长的价值；</span></p>');

SetGlobalVariableValue('Move', '15');

}
else
if ((GetGlobalVariableValue('Move')) == ('17')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十七条：做产品设计时一定不要急于使用处于测试阶段的Axure新版本，避免意外发生，我的教训就是用测试版做出的原型，由于测试版的</span><span style="font-family:Arial;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">BUG</span><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">，而全部重新返工；</span></p>');

SetGlobalVariableValue('Move', '16');

}
else
if ((GetGlobalVariableValue('Move')) == ('18')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十八条：做交互研究时一定要尽可能学习最新的Axure技巧。体验产品的最新功能，本来就是产品设计者必备的要素；</span></p>');

SetGlobalVariableValue('Move', '17');

}
else
if ((GetGlobalVariableValue('Move')) == ('19')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十九条：当你原型设计遇到任何困惑，试试仔细解读一下之前所有军规，也许你能找到想要的答案；</span></p>');

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

SetGlobalVariableValue('Move', '18');

}
});
gv_vAlignTable['u14'] = 'center';u0.tabIndex = 0;

u0.style.cursor = 'pointer';
$axure.eventManager.click('u0', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('第2集_Axure支持键盘交互效果.html');

}
});
gv_vAlignTable['u0'] = 'top';u1.tabIndex = 0;

u1.style.cursor = 'pointer';
$axure.eventManager.click('u1', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('首页.html');

}
});
gv_vAlignTable['u1'] = 'top';gv_vAlignTable['u4'] = 'center';gv_vAlignTable['u7'] = 'center';document.getElementById('u9_img').tabIndex = 0;

u9.style.cursor = 'pointer';
$axure.eventManager.click('u9', function(e) {

if ((GetGlobalVariableValue('Move')) == ('1')) {

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;text-decoration:none;">&nbsp;</span></p>');

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第二条：原型的观看者往往不是同一类对象，因此原型的设计不可避免的会有多种表现形态，每一种形态的原型都是为设计服务，没有高低之分；</span></p>');

SetGlobalVariableValue('Move', '2');

}
else
if ((GetGlobalVariableValue('Move')) == ('2')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第三条：如果按照产出方式，有手绘产出、软件产出之分,如果按照表现形式，有纸质、低保真、高保真之分；</span></p>');

SetGlobalVariableValue('Move', '3');

}
else
if ((GetGlobalVariableValue('Move')) == ('3')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第四条：如果你的产品设计周期中，原型设计时间过长，可能你需要停一下，站得远些重新审视一下自己原型设计的初衷；</span></p>');

SetGlobalVariableValue('Move', '4');

}
else
if ((GetGlobalVariableValue('Move')) == ('4')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第五条：原型是否要做到高交互、高仿真取决于观看者的需求和设计者的时间，如果简洁的原型已经完全满足观看者的需求，应该首选交互少的低保真原型，而不要过度沉浸在高交互、高仿真原型设计的快感中；</span></p>');

SetGlobalVariableValue('Move', '5');

}
else
if ((GetGlobalVariableValue('Move')) == ('5')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第六条：不要小瞧纸质原型，往往它会有磨刀不误砍柴工的功效，如果有条件，尽量不要省略，纸质原型最大的价值是思路的最初梳理和内部的多人讨论而不是自己一个人纸面画画就完成了纸质原型的阶段；</span></p>');

SetGlobalVariableValue('Move', '6');

}
else
if ((GetGlobalVariableValue('Move')) == ('6')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第七条：原型设计工具，精通一个比掌握十个更有价值，如果推荐原型工具，首选还是Axure；</span></p>');

SetGlobalVariableValue('Move', '7');

}
else
if ((GetGlobalVariableValue('Move')) == ('7')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第八条：没有人规定必须用Axure设计原型，最合适你的原型工具就是最好的；</span></p>');

SetGlobalVariableValue('Move', '8');

}
else
if ((GetGlobalVariableValue('Move')) == ('8')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第九条：原型是用来正确表达产品设计思想的工具，而不是掌握了原型工具就能正确的表达产品设计思想；</span></p>');

SetGlobalVariableValue('Move', '9');

}
else
if ((GetGlobalVariableValue('Move')) == ('9')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十条：不要像维护自己的颜面一样维护原型的设计，相反原型的价值就是要被不断的修改、推翻、打磨、锤炼,要有颠覆整个原型初稿，重新设计的气魄和担当；</span></p>');

SetGlobalVariableValue('Move', '10');

}
else
if ((GetGlobalVariableValue('Move')) == ('10')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十一条：谁都可能遇到一个不懂产品设计的领导对你的原型指指点点，尝试去理解他的真正意图，并将他喜欢的方式和你坚持的方式都表现出来，只要是正确的体验方式，用户是会给出最终的投票；</span></p>');

SetGlobalVariableValue('Move', '11');

}
else
if ((GetGlobalVariableValue('Move')) == ('11')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十二条：Axure不止可以设计Web原型，正解：Axure可以设计Web、Wap、PC客户端、手机客户端、IPAD……各种平台和终端上的应用；</span></p>');

SetGlobalVariableValue('Move', '12');

}
else
if ((GetGlobalVariableValue('Move')) == ('12')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十三条：提高自己Axure技能的最好方式，模仿你喜欢的交互实例，如:IPhone、Android手机、微博、IM、SNS……；只要你能认真模仿下来，你会发现收获的不止是Axure技能，你的产品设计思想也会进步不小；</span></p>');

SetGlobalVariableValue('Move', '13');

}
else
if ((GetGlobalVariableValue('Move')) == ('13')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十四条：不要在是否研究Axure技巧上犹豫不决或者争论不休，正确的做法：掌握你需要的技巧，并在设计原型中使用；优秀的做法：掌握所有的Axure技能，并在设计原型中按需使用；</span></p>');

SetGlobalVariableValue('Move', '14');

}
else
if ((GetGlobalVariableValue('Move')) == ('14')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十五条：掌握Axure技能并不能证明你就是一个合格的产品设计者，但要想成为一名优秀的产品设计者应该掌握Axure；</span></p>');

SetGlobalVariableValue('Move', '15');

}
else
if ((GetGlobalVariableValue('Move')) == ('15')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十六条：做流程图和产出PRD文档是Axure的功能之一，但不要作为首选，让工具发挥它最擅长的价值；</span></p>');

SetGlobalVariableValue('Move', '16');

}
else
if ((GetGlobalVariableValue('Move')) == ('16')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十七条：做产品设计时一定不要急于使用处于测试阶段的Axure新版本，避免意外发生，我的教训就是用测试版做出的原型，由于测试版的</span><span style="font-family:Arial;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">BUG</span><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">，而全部重新返工；</span></p>');

SetGlobalVariableValue('Move', '17');

}
else
if ((GetGlobalVariableValue('Move')) == ('17')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十八条：做交互研究时一定要尽可能学习最新的Axure技巧。体验产品的最新功能，本来就是产品设计者必备的要素；</span></p>');

SetGlobalVariableValue('Move', '18');

}
else
if ((GetGlobalVariableValue('Move')) == ('18')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第十九条：当你原型设计遇到任何困惑，试试仔细解读一下之前所有军规，也许你能找到想要的答案；</span></p>');

SetGlobalVariableValue('Move', '19');

}
else
if ((GetGlobalVariableValue('Move')) == ('19')) {

SetWidgetRichText('u11', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:15px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">第二十条：所谓的军规，其实就是一些我的个人观点，你可以当做废话，重要的是你应该创造属于自己的原型设计军规，并身体力行。</span></p>');

SetWidgetRichText('u12', '<p style="text-align:left;"><span style="font-family:Helvetica;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">已经是最后一条了！点击左箭头浏览上一条</span></p>');

}
});
