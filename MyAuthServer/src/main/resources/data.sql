-- The encrypted client_secret is `secret`
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity) 
SELECT 'myCodeClient', '{bcrypt}$2a$10$/SsUxEqe3wCJ91Tli0IWKe8Z.rTII0gMNDyhwrPFzbam.mC2tp6ZS', 'foo,read,write', 'password,refresh_token,client_credentials,authorization_code', 'http://localhost:8080/login/oauth2/code/custom', 'ROLE_CLIENT', 300, 300
WHERE NOT EXISTS (SELECT client_id FROM oauth_client_details WHERE client_id = 'myCodeClient');

-- The encoded client_secret is `secret`
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity) 
SELECT 'myPasswordClient', '{bcrypt}$2a$10$/SsUxEqe3wCJ91Tli0IWKe8Z.rTII0gMNDyhwrPFzbam.mC2tp6ZS', 'foo,read,write', 'password,refresh_token', 'http://localhost:8080/login/oauth2/code/custom', 'ROLE_CLIENT', 300, 300
WHERE NOT EXISTS (SELECT client_id FROM oauth_client_details WHERE client_id = 'myPasswordClient');

-- The encrypted client_secret is `secret`
--INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity) 
--SELECT 'SampleClientId', '{bcrypt}$2a$10$/SsUxEqe3wCJ91Tli0IWKe8Z.rTII0gMNDyhwrPFzbam.mC2tp6ZS', 'foo,read,write,user_info', 'password,refresh_token,client_credentials,authorization_code', 'http://localhost:8083/ui2/login', 'ROLE_CLIENT', 300, 300
--WHERE NOT EXISTS (SELECT client_id FROM oauth_client_details WHERE client_id = 'SampleClientId');


