package groovy.net.fly78.dafei1288



/**
 * groovy.net.fly78.dafei1288
 * 
 * 递归参数路径下的所有文件路径和文件
 * 
 * 调用tree();
 * 
 * @parpam String 递归路径
 * 
 * @author Administrator
 *
 * 5:17:01 PM
 */
public class TreeGroovy{

	def fileFace = { File file ->
    return (file.isDirectory() ? "[${file.name}]" : "${file.name}")
}

def connectStr = { int index, int size ->
    return (index == size - 1) ? '|__' : '|--';
}

def placeHolderStr = { int index, List levels ->
    return levels.contains(j) ? '|  ' : '   ';
}

def dump 
dump = { File context, int depth, Stack levels ->
    def files = context.listFiles()
    int size = files.size()

    for (int i = 0; i < size; i++) {
        def file = files[i]
        StringBuilder entryPath = new StringBuilder();

        for (j = 0; j < depth; j++) {
            entryPath << placeHolderStr(j, levels)
        }
        entryPath << connectStr(i, size) + fileFace(file)
        println entryPath

        if (file.isDirectory()) {
            if (i != size - 1)
                levels.push(depth)

            depth++
            dump(file, depth, levels)
            depth--

            if (i != size - 1)
                levels.pop()
        }
    }
} 

def tree = {
    if (args.size() != 1) {
        println '''Usage:\ngroovy tree.groovy DIRECTORY'''
        return
    }

    def context = new File(args[0]);

    if (!context.exists()) {
        println "[$context] does not exist!"
        return 
    }

    println fileFace(context)
    dump(context, 0, [] as Stack)
}



	
}
