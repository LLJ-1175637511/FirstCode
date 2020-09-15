activity启动模式：在manifest文件的<activity> 标签中声明 LaunchMode属性
 1、standard（默认）
    当自身activity已经返回栈顶时依旧会重新创建自身的实例
 2、singleTop
    当activity已经处于栈顶时 不会在创建新的该activity实例
 3、singleTask
    当返回栈中存在该activity的实例 会将该activity至于栈顶 并将该activity之上的activity统统出栈
 4、singleInstance
    跳转到该activity中会新建一个返回栈 存储该activity的实例
    例：1.activity1(standard) 跳转到 activity2（singleInstance模式）
        2. activity2（singleInstance模式）跳转到 activity3(standard)
        按返回键 视图显示顺序 activity3 -> activity1 -> activity2 -> 退出程序