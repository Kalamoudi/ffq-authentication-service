﻿const config = require('config.json');
const jwt = require('jsonwebtoken');

// users hardcoded for simplicity, store in a db for production applications
//const users = [{ id: 1, username: 'user', password: 'pass', firstName: 'Test', lastName: 'User' }];

module.exports = {
    authenticate,
    getAll
};

async function authenticate({ username, password/*, userType */}) {
    const MongoClient = require('mongodb').MongoClient; 
    const url = "mongodb://localhost:27017/"; 
    const db = await MongoClient.connect(url);
    const dbo = db.db("ffq_database");
    var query = { username: username, userpassword: password };
    var user = await dbo.collection("admins").find(query).toArray();
    if(!Object.keys(user).length){
        user = await dbo.collection("clinicians").find(query).toArray();
    }
    if(!Object.keys(user).length){
        user = await dbo.collection("parents").find(query).toArray();
    }

    

    if (Object.keys(user).length) {
        const token = jwt.sign({ sub: user.id }, config.secret);
        const { password, ...userWithoutPassword } = user;
        return {
            ...userWithoutPassword,
            token
        };
    }
}

async function getAll() {
    return users.map(u => {
        const { password, ...userWithoutPassword } = u;
        return userWithoutPassword;
    });
}
