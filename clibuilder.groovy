import groovy.cli.picocli.CliBuilder

/**
 * create by
 * @author hujin 2020/9/13
 */
def cli = new CliBuilder(
        usage: 'weather [<options>]',
        header: 'Options',
        footer: 'And here we put footer text.'
)

cli.with {
    h longOpt: 'help', 'Print this help text and exit.'
    n(longOpt: 'max-count', args: 1, argName: 'number',
            'Limit the number of days shown')
    '1' longOpt: 'one', "Show today's forecast"
    '2' longOpt: 'two', "Show today's and tomorrow's forecast"
    _(longOpt: 'url', args: 1, argName: 'URL',
            'Use given URL to query for weather.')
    D(args: 2, valueSeparator: '=', argName: 'property=value',
            'Use value for given property.')
}

def options = cli.parse(args)

if (!options) {
    System.err << 'Error while parsing command-line options.\n'
    System.exit 1
}

if (options.arguments().size() <2 || options.h) {
    cli.usage()
    System.exit 0
}

if (options.n) {
    println options.n
}
if (options.'1') {
    // show weather for one day
}
if (options.url) {
    URI uri = new URI(options.url)
}
if (options.Ds) {
    assert options.Ds.class == ArrayList.class
    println options.Ds
}
