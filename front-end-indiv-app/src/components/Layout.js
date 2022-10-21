import React, { Component } from 'react';
import { Container } from 'reactstrap';
import { navbar } from './navbar/navbar';
import "../index.css";

export class Layout extends Component {
  static displayName = Layout.name;

  render() {
    return (
      <div class="style">
        <navbar />
            <Container>
            {this.props.children}
            </Container>
      </div>
    );
  }
}
export default Layout;