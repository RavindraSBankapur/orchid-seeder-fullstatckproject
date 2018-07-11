import React from 'react';
import ReactDOM from 'react-dom';
import registerServiceWorker from './registerServiceWorker';
import Container from './container/container';
import RouterComponent from './routers/routerComponent';


ReactDOM.render(<RouterComponent />, document.getElementById('root'));
registerServiceWorker();
