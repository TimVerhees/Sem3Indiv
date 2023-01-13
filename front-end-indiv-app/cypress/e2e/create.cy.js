describe('create.cy.js', () => {
    it("should create user", () => { 
        cy.visit("http://localhost:3000")
        cy.get('a[id="signup"]').click()
        cy.get('input[id="userTextbox"]').type('Cypress Test'),{force: true}
        cy.get('input[id="passTextbox"]').type('averystrongpassword'),{force: true}
        cy.get('a[id="signbtn"]').click()
        cy.get('h3[id="loginsucces"]').should('be.visible')
    })})