describe('login.cy.js', () => {
    it("should login", () => {
        cy.visit("http://localhost:3000")
        cy.get('input[id="userTextbox"]').type('Test Admin'),{force: true}
        cy.get('input[id="passTextbox"]').type('averystrongpassword'),{force: true}
        cy.get('a[id="logbtn"]').click()
        cy.get('p[id="loggedintxt"]').should('contain', 'Logged in!')
    })
})