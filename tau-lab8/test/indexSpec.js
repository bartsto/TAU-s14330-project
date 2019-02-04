describe("TAU lab 8 test", function () {
    jasmine.clock().install();

    beforeEach(function () {
        let s = spyOn(console, 'log').and.callThrough();
        $('body').append(`
            <input type="text" name="teamName" class="my-input" />
        `);
    });

    afterEach(function () {
        $('input').remove();
    });

    it("should add invalid class", function () {
        const element = $('input[name=teamName]');
        element.validate(/[a-z]/);
        expect(element.hasClass('invalid')).toBe(true);
    });

    it("should not add invalid class", function () {
        const element = $('input[name=teamName]');
        element.val('abc');
        element.validate(/[a-z]/);
        expect(element.hasClass('invalid')).toBe(false);
    });

    it("should work for more than 1 element", function () {
        $('body').append(`
            <input type="text" name="stadiumName" class="my-input" />
        `);
        const elements = $('.my-input');
        elements.validate(/[a-z]/);
        elements.each(function() {
            expect($(this).hasClass('invalid')).toBe(true);
        })
    });
});