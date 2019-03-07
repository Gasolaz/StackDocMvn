const {watch, task, series, src, dest} = require('gulp'),
    sass = require('gulp-sass'),
    autoprefixer = require('gulp-autoprefixer'),
    cleancss = require('gulp-clean-css'),
    rename = require('gulp-rename'),
    uglify = require('gulp-uglify'),
    concat = require('gulp-concat'),
    htmlmin = require('gulp-htmlmin'),
    babel = require('gulp-babel');

task('sass', function () {
  return src('./web/sass/*.scss')
      .pipe(sass().on('error', sass.logError))
      .pipe(autoprefixer({
        browsers: ['last 2 versions'],
        cascade: false
      }))
      .pipe(cleancss({compatibility: 'ie8'}))
      .pipe(rename({suffix: '.min'}))
      .pipe(dest('./web/build/static/css'))
});

task('minify-js', function () {
  return src(
      [
        'node_modules/@babel/polyfill/dist/polyfill.js',
        './web/scripts/**/*.js'
      ])
      .pipe(concat('main.js'))
      .pipe(babel({
        presets: ['@babel/preset-env']
      }))
      .pipe(uglify())
      .pipe(rename({suffix: '.min'}))
      .pipe(dest('./web/build/static/js'))
});

task('minify-html', function () {
  return src('./web/index.html')
      .pipe(htmlmin({collapseWhitespace: true}))
      .pipe(dest('./web/build/static'))
});

task('default', () => {
  watch('./web/sass/**/*.scss', series('sass'));
  watch('./web/scripts/**/*.js', series('minify-js'));
  watch('./web/*.html', series('minify-html'));
});
