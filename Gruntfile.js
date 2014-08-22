module.exports = function (grunt) {

    grunt.initConfig({
        less: {
            default: {
                options: {
                    compress: false,
                    optimization: 0
                },
                files: {
                    "src/main/webapp/resources/css/index.min.css": "src/main/webapp/src/less/index.less",
                    "src/main/webapp/resources/css/auth.min.css": "src/main/webapp/src/less/auth.less",
                    "src/main/webapp/resources/css/posts.min.css": "src/main/webapp/src/less/posts.less"
                }
            }
        },
        watch: {
            styles: {
                files: ['src/main/webapp/src/less/**/*.less'],
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