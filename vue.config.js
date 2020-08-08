const path = require('path')

module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        '@': path.join(__dirname, 'src', 'main', 'frontend')
      }
    },
    entry: {
      app: path.join(__dirname, 'src', 'main', 'frontend', 'main.js')
    }
  },
  outputDir: path.join(__dirname, 'target', 'generated-sources', 'gen-frontend')
}