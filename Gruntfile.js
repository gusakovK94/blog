module.exports = function (grunt) {

    grunt.initConfig({
        less: {
            default: {
                options: {
                    compress: false,
                    optimization: 0
                },
                files: {
                    "static/css/index.min.css": "src/less/index.less",
                    "static/css/auth.min.css": "src/less/auth.less",
                    "static/css/posts.min.css": "src/less/posts.less"
                }
            }
        },
        watch: {
            styles: {
                files: ['src/less/**/*.less'],
                tasks: ['less:default'],
                options: {
                    nospawn: true
                }
            }
        }

    });

    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.registerTask('default', ['less', 'watch']);


};