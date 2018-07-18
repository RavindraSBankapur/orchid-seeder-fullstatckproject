import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Container from './components/container';
import Header from './components/header';
import Footer from './components/footer';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<Container />, document.getElementById('root'));
registerServiceWorker();
