/*
  Webpack Configuration for Browser UI
 */

module.exports = {
    mode: "none",
    entry: './src/js/index_ui.js',
    output: {
	path: __dirname+"/../../target/webpack/bundles",
	filename: 'ui_bundle.js',
    },
    target: "web",
}
