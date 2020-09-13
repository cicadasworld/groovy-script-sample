import groovy.transform.ToString

/**
 * create by
 * @author hujin 2020/9/11
 */
@ToString
class Book {
    def title
    def summary
    def sections = []
}

@ToString
class Section {
    def title
    def chapters = []
}

@ToString
class Chapter {
    def title
}

def builder = new ObjectGraphBuilder()

def book = builder.book(
    title: "Groovy In Action 2nd Edition",
    summary: "Groovy in Action, Second Edition is a thoroughly revised, comprehensive guide to Groovy programming.") {
    section(title: "Section 1") {
        chapter(title: "Chapter 1")
        chapter(title: "Chapter 2")
        chapter(title: "Chapter 3")
    }
    section(title: "Section 2") {
        chapter(title: "Chapter 4")
        chapter(title: "Chapter 5")
        chapter(title: "Chapter 6")
    }
}

println book
assert book.title == "Groovy In Action 2nd Edition"
assert book.sections.size() == 2
assert book.sections[0].title == "Section 1"
assert book.sections[0].chapters.size() == 3
