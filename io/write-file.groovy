/**
 * create by
 * @author hujin 2020/9/12
 */
// append
new File('dummy.txt').append('append')

// append (specify encoding)
new File('dummy.txt').append('append', 'UTF-8')

// left shift
new File('dummy.txt') << 'append text'

// write
new File('dummy.txt').write('write')

// write (specify encoding)
new File('dummy.txt').write('write', 'UTF-8')

// text property
new File('dummy.txt').text = 'append'

// set text (specify encoding)
new File('dummy.txt').setText('append', 'UTF-8')

// withWriter()
new File('dummy.txt').withWriter { writer ->
    writer << 'aaa'
}

// withWriter() (specify encoding)
new File('dummy.txt').withWriter('UTF-8') { writer ->
    writer << 'ccc'
}

// withWriterAppend()
new File('dummy.txt').withWriterAppend ('UTF-8') { writer ->
    writer << 'ccc'
}