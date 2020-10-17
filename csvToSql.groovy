/**
 * hujin created on 2020/9/12
 *
 * 非解析行
 * 非解析行
 * root,/
 * dog,root
 * cat,root
 * akita,root/dog
 * kuro,root/cat
 */

class Row {
 	String name, parentPath
}

class Unit {
 	String id, name, fullName, parentId, searchKey, lng, lat, location
}

// read csv data file
def pathToRow = [:]
new File("input.csv").eachLine { line, nb ->
 	if (nb == 1) return // remove first row
 	def cols = line.replace('"', '').tokenize(',')
 	def name = cols[0]?.trim()
 	def parentPath = cols[1]?.trim()

 	def path = "$parentPath/$name"
 	def row = new Row(name: name, parentPath: parentPath)
 	if (nb == 2) { // 第三行即根节点，path和name相同
        pathToRow[name] = row
 	} else {
 		pathToRow[path] = row
 	}
}

 // generate path -> id(uuid)
def pathToId = [:]
pathToRow.each { path, row ->
	def id = UUID.randomUUID().toString().replace('-', '')
	pathToId[path] = id
}

def units = []
pathToRow.each { path, row ->
	def id = pathToId[path]
	def name = row.name
	def parentId = pathToId[(row.parentPath)]
	def fullName = path.tokenize('/').join()
	def unit = new Unit(id: id, name: name, fullName: fullName, parentId: parentId)
	units << unit
}

String s = ""
units.each { unit ->
	def id = unit.id
	def name = unit.name
	def fullName = unit.fullName
	def parentId = unit.parentId
	def location = unit.location
	def sql = "INSERT INTO unit (id, name, full_name, parent_id) VALUES ('$id', '$name', '$fullName', '$parentId');\n"
	s += sql
}

// write sql file
def sqlFile = new File('unit.sql')
sqlFile.write(s)