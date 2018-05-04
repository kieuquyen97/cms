var gulp = require('gulp');
var sass = require('gulp-sass');
var babel = require('gulp-babel');
var rename = require('gulp-rename');
var sequence = require('gulp-sequence');
var clean = require('gulp-clean');

const RES_DIR = 'src/main/resources'; // Resources directory
const FE_SRC_DIR = `${RES_DIR}/frontend`; // Frontend directory

function swallowErr(err) {
    console.log(err);
    this.emit('end');
}

gulp.task('clean', function() {
    return gulp.src([
        `${RES_DIR}/static/js/**/*`,
        `${RES_DIR}/static/css/**/*`
        ])
        .pipe(clean());
});

gulp.task('sass', function() {
    return gulp.src(`${FE_SRC_DIR}/sass/*.scss`)
        .pipe(sass())
        .on('error', swallowErr)
        .pipe(rename({
            dirname: ''
        }))
        .pipe(gulp.dest(`${RES_DIR}/static/css`));
});

gulp.task('babel', function() {
    return gulp.src(`${FE_SRC_DIR}/js/*.js`)
        .pipe(babel({
            presets: ['env']
        }))
        .pipe(rename({
            dirname: ''
        }))
        .pipe(gulp.dest(`${RES_DIR}/static/js`));
});


gulp.task('watch', function () {
    gulp.watch(`${FE_SRC_DIR}/sass/**/*.scss`, ['sass']);
    gulp.watch(`${FE_SRC_DIR}/js/**/*.js`, ['babel']);
});

gulp.task('default', sequence('clean', ['sass', 'babel'], 'watch'));