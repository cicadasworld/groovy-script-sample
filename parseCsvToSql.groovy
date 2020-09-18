/**
 * create by
 * @author hujin 2020/9/12
 *
 * 非解析行
 * 非解析行
 * root,/
 * dog,root
 * cat,root
 * akita.dog
 * kuro,cat
 */

class Row {
 	String name, parentPath, lng, lat, location
}

class Unit {
 	String id, name, parentId, lng, lat, location
}

// read csv data file
def pathToRow = [:]
new new File("input.csv").eachLine { line, nb ->
 	if (nb == 1 || nb == 2) return // remove first 2 rows
 	def cols = line.replace('"', '').splite(',')
 	def name = cols[0]?.trim()
 	def parentPath = cols[1]?.trim()
 	def lng = cols[2]?.trim()
 	def lat = cols[3]?.trim()
 	def location = cols[4]?.trim()

 	def path = "$parentPath/$name"
 	def row = new Row(naem: name, parentPath: parentPath, lng: lng, lat: lat, location: location)
 	if (nb == 3) { // 第三行即根节点，path和name相同
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
	def lng = row.lng
	def lat = row.lat
	def location = row.location
	def unit = new Unit(id: id, name: name, parentId: parentId, lng: lng, lat: lat, location: location)
	units << unit
}

String s = ""
units.each { unit ->
	def id = unit.id
	def name = unit.name
	def parentId = unit.parentId
	def location = unit.location
	def sql = "INSERT INTO unit (id, name, parent_id) VALUES ('$id', "
	if (location) {
		sql += "'$name($location)',"
	} else {
		sql += "'$name',"
	}
	if (parentId) {
		sql += "'$parentId'"
	} else {
		sql += parentId
	}
	sql += ");\n"
	s += sql
}

// write sql file
def sqlFile = new File('unit.sql')
sqlFile.write(s)
