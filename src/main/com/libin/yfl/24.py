# coding:utf-8
'''  尝试ing
722. 删除注释
给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第i行源码。 这表示每行源码由\n分隔。
在 C++ 中有两种注释风格，行内注释和块注释。
字符串// 表示行注释，表示//和其右侧的其余字符应该被忽略。
字符串/* 表示一个块注释，它表示直到*/的下一个（非重叠）出现的所有字符都应该被忽略。（阅读顺序为从左到右）非重叠是指，字符串/*/并没有结束块注释，因为注释的结尾与开头相重叠。
第一个有效注释优先于其他注释：如果字符串//出现在块注释中会被忽略。 同样，如果字符串/*出现在行或块注释中也会被忽略。
如果一行在删除注释之后变为空字符串，那么不要输出该行。即，答案列表中的每个字符串都是非空的。
样例中没有控制字符，单引号或双引号字符。比如，source = "string s = "/* Not a comment. */";" 不会出现在测试样例里。（此外，没有其他内容（如定义或宏）会干扰注释。）
我们保证每一个块注释最终都会被闭合， 所以在行或块注释之外的/*总是开始新的注释。
最后，隐式换行符可以通过块注释删除。 有关详细信息，请参阅下面的示例。
从源代码中删除注释后，需要以相同的格式返回源代码。
示例 1:
输入:
source = ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"]
示例代码可以编排成这样:
/*Test program */
int main()
{
  // variable declaration
int a, b, c;
/* This is a test
   multiline
   comment for
   testing */
a = b + c;
}
输出: ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
     ['int main()', '{ ', '  ', 'int a, b, c;', 'a = b + c;', '}']
编排后:
int main()
{

int a, b, c;
a = b + c;
}

解释:
第 1 行和第 6-9 行的字符串 /* 表示块注释。第 4 行的字符串 // 表示行注释。
示例 2:

输入:
source = ["a/*comment", "line", "more_comment*/b"]
输出: ["ab"]
解释: 原始的 source 字符串是 "a/*comment\nline\nmore_comment*/b", 其中我们用粗体显示了换行符。删除注释后，隐含的换行符被删除，留下字符串 "ab" 用换行符分隔成数组时就是 ["ab"].
'''

a = ["int main()", "{ ", "  ", "int a, b, c;", "a = b + c;", "}"]
b = ['int main()', '{ ', '  ', 'int a, b, c;', 'a = b + c;', '}']


def removeComments(source):
    list1 = []
    tag = 0
    for line in source:
        if line.find('//') == -1 and line.find('/*') == -1 and line.find('*/') == -1 and tag == 0:
            list1.append(line)
            continue
        if line.find('//') != -1:
            if line.find('/*') == -1:
                if line.split('//')[0]:
                    list1.append(line.split('//')[0])
                continue
            else:
                if line.find('//') < line.find('/*'):
                    continue
                else:
                    tag = 1
                    continue
        if line.find('/*') != -1:
            tag = 1
            if line.split('/*')[0]:
                list1.append(line.split('/*')[0])
        if line.find('*/') != -1:
            if tag == 1:
                tag = 0
                if line.split('*/')[-1]:
                    list1[-1] += line.split('*/')[-1]
            else:
                list1.append(line)

    return list1


# source = ["void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"]
# ["void func(int k) {","   k = k*2/4;","   k = k/2;*/","}"]
# ['void func(int k) {', '   k = k*2/4;', '   k = k/2;*/', '}']
# source = ["a/*comment", "line", "more_comment*/b"]
source = ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test",
          "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"]
print(removeComments(source))

# 别人的代码
class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        res = re.sub('//.*|/\*(\s|.)*?\*/', '', '\n'.join(source))
        return filter(len, res.split('\n'))