# coding:utf-8
'''
面试题 17.07. 婴儿名字
每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
在结果列表中，选择字典序最小的名字作为真实名字。
示例：
输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
输出：["John(27)","Chris(36)"]
'''

import collections


def trulyMostPopular(names, synonyms):
    list_name = []
    dict1 = collections.OrderedDict()
    for each in synonyms:
        a, b = each.split(',')[0].split('(')[-1], each.split(',')[-1].split(')')[0]
        if len(list_name) == 0:
            list_name.append(a + '_' + b)
            continue
        flag = 0
        for i in range(len(list_name)):
            if a in list_name[i]:
                list_name[i] = list_name[i] + '_' + b
                flag = 1
                break
            elif b in list_name[i]:
                list_name[i] = list_name[i] + '_' + a
                flag = 1
                break
        if flag == 0:
            list_name.append(a + '_' + b)
    for each in list_name:
        dict1[each] = 0
    dict2 = collections.OrderedDict()
    for each in names:
        name, num = each.split('(')[0], int(each.split('(')[-1].split(')')[0])
        for key in dict1:
            if key.find(name) != -1:
                if key.find('#') == -1:
                    dict1[name+'#'+key] = dict1.pop(key)+num
                    dict2[name+'#'+key] = dict1[name+'#'+key]
                    break
                else:
                    dict1[key] += num
                    dict2[key] += num
                    break
    res = []
    for key in dict2:
        res.append(key.split('#')[0]+'('+str(dict2[key])+')')
    return res



names = ["John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"]
synonyms = ["(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"]
print(trulyMostPopular(names, synonyms))

